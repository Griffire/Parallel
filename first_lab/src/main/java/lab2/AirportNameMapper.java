package lab2;


import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

public class AirportNameMapper extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {
    public static final String NAME_PATTERN = "[,]";
    public static final int AIRPORT_CODE_NAME = 0;
    public static final int AIRPORT_FIRST_NAME = 1;
    public static final int AIRPORT_SECOND_NAME = 2;


    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,
            InterruptedException {
        String line = value.toString();
        String [] words = line.split(NAME_PATTERN);
        if (words.length > 2) {
            context.write(new AirportWritableComparable(words[AIRPORT_CODE_NAME], "0"),
                    new Text(words[AIRPORT_FIRST_NAME] + "," + words[AIRPORT_SECOND_NAME]));
        } else if (words.length == 2){
            context.write(new AirportWritableComparable(words[AIRPORT_CODE_NAME], "0"), new Text(words[AIRPORT_FIRST_NAME]));
        }
    }
}