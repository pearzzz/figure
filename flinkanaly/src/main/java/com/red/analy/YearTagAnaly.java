package com.red.analy;

import com.red.map.YearTagMap;
import com.red.reduce.YearTagReduce;
import com.red.result.YearTagResult;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import com.red.sink.YearTagSink;

import java.util.Properties;

/**
 * @Description 年代
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:22 2022-07-27
 */
public class YearTagAnaly {
    public static void main(String[] args) {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.100.200:9092");
        properties.setProperty("group.id", "analy");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("userinfo", new SimpleStringSchema(), properties);
        //指定偏移量
        myConsumer.setStartFromLatest();


        DataStream<String> stream = env
                .addSource(myConsumer);
        DataStream<YearTagResult> mapstream  = stream.flatMap(new YearTagMap());
        DataStream<YearTagResult> reducestream  = mapstream.keyBy("groupField").timeWindow(Time.minutes(5L)).reduce(new YearTagReduce());
        reducestream.addSink(new YearTagSink());

        //stream.print();
        try {
            env.execute("YearTagAnaly");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
