package lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportReducer extends Reducer<Text, FloatWritable, Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<FloatWritable> values, Context context) throws
            IOException, InterruptedException {
        long count=0;
        float average = (float) 0.0;
        float min = Float.MAX_VALUE;
        float max = (float)(-1.0) * Float.MAX_VALUE;
        for (FloatWritable v : values) {
            auto i = Float.parseFloat(v.get());
            average = average * count + i;
            count++;
            average /= (float)count;
            if (i > max){
                max = i;
            }
            if (i < min){
                min = i;
            }
        }
//        context.write(key, new FloatWritable(average));
        context.write(key, new Text("average: " + average + " max: " + max + " min: " + min ));

    }
}