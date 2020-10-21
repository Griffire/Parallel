package lab3;

//import org.apache.spark.mapred. ;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class AirportApp {
    private JavaSparkContext sc;

    public static void main(String[] args) throws Exception {
       setup(args);
       execute();
    }

    public void setup(String[] args){
        SparkConf sparkConf = new SparkConf().setAppName("Lab3");
        sc = new JavaSparkContext(sparkConf);
    }

    public void execute

}
