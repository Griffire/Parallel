package lab3;

import org.apache.spark.broadcast.Broadcast;
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
        JavaRDD<String> fAIRPORT_ID = dist2.filter(s->s._2() >= 2).keys();


        Map<String,String> AIRPORT_NAMES = fAIRPORT_ID.map(str -> str.split(",")).mapToPair(str -> new Tuple2<>(str[0],str[1])).collectAsMap();


        final Broadcast<Map<String, String>> airportsBroadcasted =
                sc.broadcast(AIRPORT_NAMES);

        JavaPairRDD<Tuple2<String,String>, Times> fDelay = fAIRPORT_TIMES.map( s -> s.split(",")).mapToPair(strings ->
                new Tuple2<>(new Tuple2<>(strings[11], strings[14]),
                new Times(strings[18],strings[19]))).groupByKey().mapValues(s -> new Times().counting(s));

        JavaRDD<String> output = fDelay.map(s -> {
            String str = "NameFrom : " + airportsBroadcasted.value().get(s._1._1) + " NameTo" +
                    airportsBroadcasted.value().get(s._1._2) + " AverageDelay : " + s._2.getDelay() +
                    " AverageCancelled : " + s._2.getCanceled();
            return str;
                 }) ;
        output.saveAsTextFile("output");


    }

}


