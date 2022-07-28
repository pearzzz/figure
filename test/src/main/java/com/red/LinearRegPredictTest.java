package com.red;

import com.alibaba.alink.operator.batch.BatchOperator;
import com.alibaba.alink.operator.batch.recommendation.AlsTrainBatchOp;
import com.alibaba.alink.operator.batch.regression.LinearRegTrainBatchOp;
import com.alibaba.alink.operator.batch.source.MemSourceBatchOp;
import com.alibaba.alink.operator.stream.StreamOperator;
import com.alibaba.alink.operator.stream.recommendation.AlsSimilarUsersRecommStreamOp;
import com.alibaba.alink.operator.stream.regression.LinearRegPredictStreamOp;
import com.alibaba.alink.operator.stream.source.MemSourceStreamOp;
import org.apache.flink.types.Row;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 10:26 2022-07-28
 */
public class LinearRegPredictTest {

    public static void main(String[] args) throws Exception {
        List<Row> df = Arrays.asList(Row.of(2, 1, 1),
                Row.of(3, 2, 1),
                Row.of(4, 3, 2),
                Row.of(2, 4, 1),
                Row.of(4, 3, 1),
                Row.of(2, 2, 1),
                Row.of(1, 2, 1));

        BatchOperator<?> batchData = new MemSourceBatchOp(df, "f0 int,f1 int,label int");
        StreamOperator<?> streamOperator = new MemSourceStreamOp(df, "f0 int,f1 int,label int");
        String[] cloumns = new String[]{"f0", "f1"};
        BatchOperator lr = new LinearRegTrainBatchOp().setFeatureCols(cloumns).setLabelCol("label");
        BatchOperator model = batchData.link(lr);
        StreamOperator<?> predictStreamOp = new LinearRegPredictStreamOp(model).setPredictionCol("pred");
        StreamOperator<?> streamOperator1 = predictStreamOp.linkFrom(streamOperator);
        streamOperator1.print();
        StreamOperator.execute();
    }
}
