package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split("[ , ]");
        context.write(new Text(words[13]),new FloatWritable(words[17]));
//        for (String word : words) {
//            context.write(new Text(word), new IntWritable(1));
//        }

    }
}

//17 18