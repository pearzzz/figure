package com.red.reduce;

import com.red.result.YearTagResult;
import org.apache.flink.api.common.functions.ReduceFunction;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:10 2022-07-27
 */
public class YearTagReduce implements ReduceFunction<YearTagResult> {
    @Override
    public YearTagResult reduce(YearTagResult yearTagResult, YearTagResult t1) throws Exception {
        long numbers = yearTagResult.getNumbers();
        long nubmers2 = t1.getNumbers();
        yearTagResult.setNumbers(numbers+nubmers2);
        return yearTagResult;
    }
}
