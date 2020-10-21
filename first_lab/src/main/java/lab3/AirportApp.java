package lab3;

//import org.apache.spark.mapred. ;

import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class AirportApp {

    public static void main(String[] args) throws Exception {
        JavaSparkContext sc;
        SparkConf sparkConf = new SparkConf().setAppName("Lab3");
        sc = new JavaSparkContext(sparkConf);
     //   String inputFile = "";
        JavaRDD<String> distFile = sc.textFile( "war-and-peace-1.txt");
        JavaRDD<String> splitted = distFile.flatMap(
                s -> Arrays.stream(s.split( " ")).iterator());
        JavaPairRDD<String, Long> wordsWithCount = splitted.mapToPair(
                s -> new Tuple2<>(s, 1l) );
        wordsWithCount.saveAsHadoopFile("war-and-peace-2.txt", String.class, Long.class, TextOutputFormat.class);
        //JavaPairRDD<String,Long>

    }
}
