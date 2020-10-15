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
        String name = v.iterNext().toString();

        while (v.hasNext()){
        //for (Text v : values) {

           // if (key.getCode().charAt(0) == '1') {
                float i = Float.parseFloat(v.toString());
                average = average * count + i;
                count++;
                average /= (float) count;
                if (i > max) {
                    max = i;
                }
                if (i < min) {
                    min = i;
                }
//            } else {
//                name = v.toString();
            }
        }
        if (count > 0) {
            context.write(new Text(key.getCode() + "__" + key.getName()), new Text(" Name:  " + name + " average: " + average + " max: " + max + " min: " + min));
        }
    }
}