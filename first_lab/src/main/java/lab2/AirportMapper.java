package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    public static final String DELAY_PATTERN = "[ ,]";
    public static final int AIRPORT_CODE = 14;
    public static final int FLIGHT_DELAY = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split(DELAY_PATTERN);


        if (words[AIRPORT_CODE].length() < 7 && words[FLIGHT_DELAY].length() > 0 && Float.parseFloat(words[FLIGHT_DELAY]) != (float) 0.0) {
            context.write(
                    new AirportWritableComparable("\"" + words[AIRPORT_CODE] + "\"","1"),
                    new Text(words[FLIGHT_DELAY]));
        }
    }
}

//17 18