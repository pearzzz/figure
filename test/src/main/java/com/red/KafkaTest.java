package com.red;

import com.alibaba.alink.operator.stream.StreamOperator;
import com.alibaba.alink.operator.stream.source.KafkaSourceStreamOp;
import org.junit.Test;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:42 2022-07-28
 */
public class KafkaTest {

    @Test
    public void testKafka() throws Exception {
        StreamOperator<?> streamOperator = new KafkaSourceStreamOp().
                setBootstrapServers("192.168.10.200:9092").setTopic("test").
                setStartupMode("EARLIEST").setGroupId("red");
        streamOperator.print();
        StreamOperator.execute();
    }
}
