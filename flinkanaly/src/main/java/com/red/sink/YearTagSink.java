package com.red.sink;

import com.red.result.YearTagResult;
import com.red.utils.ClickHouseUtil;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.*;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:13 2022-07-27
 */
public class YearTagSink implements SinkFunction<YearTagResult> {
    @Override
    public void invoke(YearTagResult value) {
        String tableName = "yearTagInfo";
        Map<String,Object> dataMap = new HashMap<String,Object>();
        long nubmers = value.getNumbers();
        String timeString = value.getTimeString();
        String yearTag = value.getYearTag();
        Random random = new Random();
        int id = random.nextInt(10000);
        dataMap.put("id",id);
        dataMap.put("yearTag",yearTag);
        dataMap.put("timeString",timeString);
        dataMap.put("numbers",nubmers);
        Set<String> intFiledSet = new HashSet<String>();
        intFiledSet.add("id");
        intFiledSet.add("numbers");
        ClickHouseUtil.saveData(tableName,dataMap,intFiledSet);

    }
}
