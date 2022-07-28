package com.red.map;

import com.alibaba.fastjson.JSONObject;
import com.red.entity.UserInfo;
import com.red.result.YearTagResult;
import com.red.utils.DateUtils;
import com.red.utils.HbaseUtils;
import com.red.utils.YearTagUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:49 2022-07-27
 */
public class YearTagMap implements FlatMapFunction<String, YearTagResult> {
    @Override
    public void flatMap(String s, Collector<YearTagResult> collector) throws Exception {
        UserInfo userinfo = JSONObject.parseObject(s, UserInfo.class);
        YearTagResult yearTagResult = new YearTagResult();
        long userid = userinfo.getId();
        int age = userinfo.getAge();
        String yearTag = YearTagUtils.getYearTag(age);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("yearTag", yearTag);
        //用户标签
        HbaseUtils.putData(userid + "", "userinfo", data);
        //用户标签的统计
        String timeString = DateUtils.getDateStringBy(userinfo.getCreateTime(), "yyyy-MM-dd");
        String groupField = "yeartag==" + timeString + "==" + yearTag;
        long numbers = 1L;
        yearTagResult.setGroupField(groupField);
        yearTagResult.setYearTag(yearTag);
        yearTagResult.setTimeString(timeString);
        yearTagResult.setNumbers(numbers);
        collector.collect(yearTagResult);
    }
}
