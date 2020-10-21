package lab3;

//import org.apache.spark.mapred. ;

//import org.apache.hadoop.mapred.TextOutputFormat;
//import org.apache.spark.SparkConf;
//import org.apache.spark.api.java.JavaPairRDD;
//import org.apache.spark.api.java.JavaRDD;
//import org.apache.spark.api.java.JavaSparkContext;
//import scala.Tuple2;
//
//import java.util.Arrays;
//
//public class AirportApp {
//
//    public static void main(String[] args)  {
//        JavaSparkContext sc;
//        SparkConf sparkConf = new SparkConf().setAppName("AirportApp");
//        sc = new JavaSparkContext(sparkConf);
//     //   String inputFile = "";
//        JavaRDD<String> distFile = sc.textFile( "warandpeace-1.txt");
//        JavaRDD<String> splitted = distFile.flatMap(
//                s -> Arrays.stream(s.split( " ")).iterator());
//        JavaPairRDD<String, Long> wordsWithCount = splitted.mapToPair(
//                s -> new Tuple2<>(s, 1l) );
//        wordsWithCount.saveAsHadoopFile("war-and-peace-2.txt", String.class, Long.class, TextOutputFormat.class);
//        //JavaPairRDD<String,Long>
//
//    }
//}



import scala.Tuple2;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class JavaWordCount {
    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) throws Exception {

        if (args.length < 1) {
            System.err.println("Usage: JavaWordCount <file>");
            System.exit(1);
        }

        SparkSession spark = SparkSession
                .builder()
                .appName("JavaWordCount")
                .getOrCreate();

        JavaRDD<String> lines = spark.read().textFile(args[0]).javaRDD();

        JavaRDD<String> words = lines.flatMap(s -> Arrays.asList(SPACE.split(s)).iterator());

        JavaPairRDD<String, Integer> ones = words.mapToPair(s -> new Tuple2<>(s, 1));

        JavaPairRDD<String, Integer> counts = ones.reduceByKey((i1, i2) -> i1 + i2);

        List<Tuple2<String, Integer>> output = counts.collect();
        for (Tuple2<?,?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }
        spark.stop();
    }
}