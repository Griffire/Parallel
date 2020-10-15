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
        String name = "";
        for (Text v : values) {
//            if (key.getCode().compareTo("1") == 0) {
//                float i = Float.parseFloat(v.toString());
//                average = average * count + i;
//                count++;
//                average /= (float) count;
//                if (i > max) {
//                    max = i;
//                }
//                if (i < min) {
//                    min = i;
//                }
//            } else {
                name = v.toString();
//            }
        }
//        context.write(key, new FloatWritable(average));
        context.write(new Text(key.getName().charAt(key.getName().length() - 1).toString()), new Text("Name:  "+ name + " average: " + average + " max: " + max + " min: " + min ));

    }
}