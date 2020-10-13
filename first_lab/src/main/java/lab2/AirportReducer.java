package lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportReducer extends Reducer<Text, IntWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws
            IOException, InterruptedException {
        long count=0;
        for (IntWritable v : values) {
            count++;
        }
        context.write(key, new LongWritable(count));
    }
}