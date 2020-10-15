package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split("[ ,]");
        if (!words[14].equals("") && words[17].length() > 0) {
            context.write(new AirportWritableComparable("\"" + words[14] + "\"","1"), new Text(words[18]));
        }
    }
}

//17 18