package lab3;

import org.apache.spark.mapred.* ;

import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Map;

public class AirportApp3 {

    public static String AIRPORT_TIMES_SPLIT = "[ ,]";
    public static String AIRPORT_ID_SPLIT = "[,]";


    public static void main(String[] args)  {
        JavaSparkContext sc;

        SparkConf sparkConf = new SparkConf().setAppName("AirportApp3");
        sc = new JavaSparkContext(sparkConf);
     //   String inputFile = "";
        JavaRDD<String> AIRPORT_TIMES = sc.textFile( "AIRPORT_TIMES.csv").
                flatMap(s -> Arrays.stream(s.split( AIRPORT_TIMES_SPLIT)).iterator());

        JavaRDD<String> AIRPORT_ID = sc.textFile( "L_AIRPORT_ID.csv").
                flatMap(s -> Arrays.stream(s.split( AIRPORT_ID_SPLIT)).iterator());;



        JavaPairRDD<String,Long> dist1 = AIRPORT_TIMES.zipWithIndex();
        JavaRDD<String> fAIRPORT_TIMES = dist1.filter(s->s._2() >= 23).keys();

        JavaPairRDD<String,Long> dist2 = AIRPORT_TIMES.zipWithIndex();
        JavaRDD<String> fAIRPORT_ID = dist1.filter(s->s._2() >= 2).keys();


        Map<String,String> AIRPORT_NAMES = 
        JavaPairRDD<String, Long> wordsWithCount = splitted.mapToPair(
                s -> new Tuple2<>(s, 1l) );
        JavaRDD<String> output = wordsWithCount.map(stringLongTuple2 -> {String str = "word:" +
                stringLongTuple2._1() + " count:" + stringLongTuple2._2();
                 return str;
                 }) ;
        output.saveAsTextFile("output");



       System.out.println("Nice!\n\n");
       //wordsWithCount.saveAsHadoopFile("war-and-peace-2.txt", String.class, Long.class, TextOutputFormat.class);
        //JavaPairRDD<String,Long>

    }

}


