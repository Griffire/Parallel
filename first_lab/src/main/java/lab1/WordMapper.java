package lab1;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
            String line = value.toString().toLowerCase();
            String [] words = line.split("[^a-z0-9а-я]");
             for (String word : words) {
                 context.write(new Text(word), new IntWritable(1));
             }

    }
}