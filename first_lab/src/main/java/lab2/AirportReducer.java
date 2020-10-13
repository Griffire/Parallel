package lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportReducer extends Reducer<Text, FloatWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<FloatWritable> values, Context context) throws
            IOException, InterruptedException {
        long count=0;
        float average = (float) 0.0;
        for (FloatWritable v : values) {
            average = average * count + v.get();
            count++;
            average /= (float)count;
        }
        context.write(key, new FloatWritable(average));
    }
}