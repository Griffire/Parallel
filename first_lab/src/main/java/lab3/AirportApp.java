package lab3;

//import org.apache.spark.mapred. ;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportApp {

    public static void main(String[] args) throws Exception {
        JavaSparkContext sc;
        SparkConf sparkConf = new SparkConf().setAppName("Lab3");
        sc = new JavaSparkContext(sparkConf);
        String inputFile = "";
        JavaRDD<String> distFile = sc.textFile( "war-and-peace-1.txt");
        
    }


}
