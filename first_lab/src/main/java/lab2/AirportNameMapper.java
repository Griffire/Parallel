package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportNameMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    public static final String NAME_PATTERN = "[,]";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split(NAME_PATTERN);
        if (words.length > 2) {
            context.write(new AirportWritableComparable(words[0], "0"), new Text(words[1] + "," + words[2]));
        } else if (words.length == 2){
            context.write(new AirportWritableComparable(words[0], "0"), new Text(words[1]));
        }
    }
}