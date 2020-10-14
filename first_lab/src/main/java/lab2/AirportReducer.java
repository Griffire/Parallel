package lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text,Text> {
    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {
        long count=0;
        float average = (float) 0.0;
        float min = Float.MAX_VALUE;
        float max = (float)(-1.0) * Float.MAX_VALUE;
        for (AirportWritableComparable v : values) {
            float i = Float.parseFloat(v.getName());
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
        context.write(key.getName(), new Text("average: " + average + " max: " + max + " min: " + min ));

    }
}