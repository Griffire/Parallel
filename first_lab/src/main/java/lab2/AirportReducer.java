package lab2;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;
import java.util.Iterator;

public class AirportReducer extends Reducer<AirportWritableComparable, Text, Text,Text> {
    @Override
    protected void reduce(AirportWritableComparable key, Iterable<Text> values, Context context) throws
            IOException, InterruptedException {

        Iterator<Text> v = values.iterator();
        long count=0;
        float average = (float) 0.0;
        float min = Float.MAX_VALUE;
        float max = (float)(-1.0) * Float.MAX_VALUE;
        String name = v.next().toString();

        while (v.hasNext()){
            float i = Float.parseFloat(v.next().toString());
            average = average * count + i;
            count++;
            average /= (float) count;
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        if (count > 0) {
            context.write(new Text(key.getName()), new Text(" Name:  " + name + " average: " + average + " max: " + max + " min: " + min));
        }
    }
}