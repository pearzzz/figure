package com.red;

import com.alibaba.alink.operator.batch.BatchOperator;
import com.alibaba.alink.operator.batch.recommendation.AlsTrainBatchOp;
import com.alibaba.alink.operator.batch.source.MemSourceBatchOp;
import com.alibaba.alink.operator.stream.StreamOperator;
import com.alibaba.alink.operator.stream.recommendation.AlsSimilarUsersRecommStreamOp;
import com.alibaba.alink.operator.stream.source.MemSourceStreamOp;
import org.apache.flink.types.Row;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:01 2022-07-28
 */
public class UserSimilar {

    public static void main(String[] args) throws Exception {
        List<Row> df = Arrays.asList(
                Row.of(1,1,0.4),
                Row.of(2,2,0.9),
                Row.of(2,3,0.5),
                Row.of(4,1,0.6),
                Row.of(4,2,0.2),
                Row.of(4,3,0.4));

        BatchOperator data1 = new MemSourceBatchOp(df,"user int,item int,rating double");
        StreamOperator data2 = new MemSourceStreamOp(df,"user int,item int,rating double");

        BatchOperator<?> als =  new AlsTrainBatchOp().setUserCol("user").setItemCol("item").setRateCol("rating").setNumIter(10).setRank(10).setLambda(0.02);
        BatchOperator model = als.linkFrom(data1);

        StreamOperator<?> predict = new AlsSimilarUsersRecommStreamOp(model).setUserCol("user").setRecommCol("rcco").setK(2).setReservedCols("user");
        StreamOperator<?> predictre = predict.linkFrom(data2);
        predictre.print();
        StreamOperator.execute();
    }
}
