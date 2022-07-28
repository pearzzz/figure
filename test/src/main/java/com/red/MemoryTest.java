package com.red;

import com.alibaba.alink.operator.stream.StreamOperator;
import com.alibaba.alink.operator.stream.source.MemSourceStreamOp;
import org.apache.flink.types.Row;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:08 2022-07-28
 */
public class MemoryTest {

    @Test
    public void memoryDataTest() throws Exception {

        List<Row> df = Arrays.asList(Row.of("1:2.0",15),
                Row.of("2:2.0",5),
                Row.of("3:2.0",51),
                Row.of("4:2.0",67));
        StreamOperator<?> streamOperator = new MemSourceStreamOp(df,new String[]{"data","socre"});
        streamOperator.print();
        StreamOperator.execute();
    }
}
