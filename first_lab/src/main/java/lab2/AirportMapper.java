package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportMapper extends Mapper<AirportWritableComparable, Text, Text, Text> {
    @Override
    protected void map(AirportWritableComparable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split("[ , ]");
//        if (!words[14].equals("DEST_AIRPORT_ID")) {
        if (words[14].length() < 7 && words[17].length() > 0) {
//            context.write(new Text(words[17]), new FloatWritable(Float.parseFloat("0.3")));
           // context.write(new Text(words[14]), new FloatWritable(Float.parseFloat(words[17])));
        //    context.write(new Text(AirportWritableComparable(words[14],"1")), new Text(words[17]));
        } else {
//            context.write(new Text("error"), new FloatWritable(Float.parseFloat("4.04")));

        }
//        for (String word : words) {
//            context.write(new Text(word), new IntWritable(1));
//        }

    }
}

//17 18