package com.red;

import com.alibaba.alink.operator.batch.BatchOperator;
import com.alibaba.alink.operator.batch.clustering.KMeansTrainBatchOp;
import com.alibaba.alink.operator.batch.source.MemSourceBatchOp;
import com.alibaba.alink.operator.stream.StreamOperator;
import com.alibaba.alink.operator.stream.clustering.KMeansPredictStreamOp;
import com.alibaba.alink.operator.stream.source.MemSourceStreamOp;
import org.apache.flink.types.Row;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:25 2022-07-28
 */
public class KmeansTest {
    public static void main(String[] args) throws Exception {
        List<Row> df = Arrays.asList(
                Row.of(0,"0 0 0"),
                Row.of(1,"0.1,0.1,0.1"),
                Row.of(2,"0.2,0.2,0.2"),
                Row.of(3,"9.1,9.1,9.1"),
                Row.of(4,"9.2,9.2,9.2"),
                Row.of(5,"7.2,8.4,5.2")
        );
        BatchOperator<?> batchOperatorData = new MemSourceBatchOp(df,"id int,vec string");
        BatchOperator<?> kmeans = new KMeansTrainBatchOp().setVectorCol("vec").setK(3);
        kmeans.linkFrom(batchOperatorData);

        StreamOperator<?> streamOperator = new MemSourceStreamOp(df,"id int,vec string");
        StreamOperator<?> pridect = new KMeansPredictStreamOp(kmeans).setPredictionCol("pred");
        pridect.linkFrom(streamOperator);
        pridect.print();
        StreamOperator.execute();
    }
}
