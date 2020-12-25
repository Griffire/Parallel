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
    public static String AIRPORT_ID_SPLIT = ",";
    private static final int NAME_PAR = 11;
    private static final int TIME_PAR = 14;
    private static final int DELAY_PAR = 18;
    private static final int DELAY_FL_PAR = 19;

    public static void main(String[] args)  {
        JavaSparkContext sc;

        SparkConf sparkConf = new SparkConf().setAppName("AirportApp3");
        sc = new JavaSparkContext(sparkConf);
        JavaRDD<String> AIRPORT_TIMES = sc.textFile( "AIRPORT_TIMES.csv");
        JavaRDD<String> AIRPORT_ID = sc.textFile( "L_AIRPORT_ID.csv");
        String Airp = AIRPORT_ID.first();
        JavaRDD<String> fAIRPORT_ID = AIRPORT_ID.filter(s -> !s.equals(Airp));
        String AirpTimes = AIRPORT_TIMES.first();
        JavaRDD<String> fAIRPORT_TIMES = AIRPORT_TIMES.filter(s -> !s.equals(AirpTimes));
        Map<String,String> AIRPORT_NAMES = fAIRPORT_ID.map(str -> str.split("\"")).mapToPair(str -> new Tuple2<>(str[1],str[3])).collectAsMap();
        final Broadcast<Map<String, String>> airportsBroadcasted =
                sc.broadcast(AIRPORT_NAMES);
        JavaPairRDD<Tuple2<String,String>, Times> fDelay = fAIRPORT_TIMES.map( s -> s.split(AIRPORT_ID_SPLIT)).mapToPair(strings ->
                new Tuple2<>(new Tuple2<>(strings[NAME_PAR], strings[TIME_PAR]),
                new Times(strings[DELAY_PAR],strings[DELAY_FL_PAR]))).groupByKey().mapValues(s -> new Times().counting(s));
        JavaRDD<String> output = fDelay.map(s -> {
            String str = "NameFrom : " + airportsBroadcasted.value().get(s._1._1) + " NameTo" +
                    airportsBroadcasted.value().get(s._1._2) + " AverageDelay : " + s._2.getDelay() +
                    " AverageCancelled : " + s._2.getCanceled();
            return str;
                 }) ;
        output.saveAsTextFile("output");
    }

}


