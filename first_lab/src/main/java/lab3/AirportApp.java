package lab3;

import org.apache.spark.mapred. ;

public class AirportApp {
    public static void main(String[] args) throws Exception {
        sparkContext.textFile("hdfs://...")
                .flatMap(line => line.split(" "))
            .map(word => (word, 1)).reduceByKey(_ + _)
                .saveAsTextFile("hdfs://...")
    }
}
