package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    public static final String DELAY_PATTERN = "[ ,]";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split(DELAY_PATTERN);

        if (words[14].length() < 7 && words[18].length() > 0 && Float.parseFloat(words[18]) != (float) 0.0) {
            context.write(new AirportWritableComparable("\"" + words[14] + "\"","1"), new Text(words[18]));
        }
    }
}

//17 18