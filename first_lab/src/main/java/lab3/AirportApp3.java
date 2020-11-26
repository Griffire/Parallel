package lab3;

import org.apache.spark.mapred.* ;

import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class AirportApp3 {

    public static void main(String[] args)  {
        JavaSparkContext sc;

        SparkConf sparkConf = new SparkConf().setAppName("AirportApp3");
        sc = new JavaSparkContext(sparkConf);
     //   String inputFile = "";
        JavaRDD<String> distFile = sc.textFile( "warandpeace1.txt");
        JavaRDD<String> distFile2 = sc.textFile( "warandpeace2.txt");


        JavaPairRDD<String,Long> dist1 = distFile.zipWithIndex();
        JavaRDD<String> f = dist1.filter(s->s._2()< 100).keys();


        JavaRDD<String> splitted = distFile.flatMap(
                s -> Arrays.stream(s.split( " ")).iterator());
        JavaPairRDD<String, Long> wordsWithCount = splitted.mapToPair(
                s -> new Tuple2<>(s, 1l) );
        JavaRDD<String> output = wordsWithCount.map(stringLongTuple2 -> {String str = "word:" +
                stringLongTuple2._1 + " count:" + stringLongTuple2._2;
                 return str;
                 }) ;
        output.saveAsTextFile("output");
      //  System.out.println("Nice!\n\n");
       //wordsWithCount.saveAsHadoopFile("war-and-peace-2.txt", String.class, Long.class, TextOutputFormat.class);
        //JavaPairRDD<String,Long>

    }

}


