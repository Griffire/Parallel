package lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import org.apache.hadoop.io.WritableComparable;


public class AirportPartitioner extends Partitioner<WritableComparable, Text> {

    @Override
    public int getPartition(WritableComparable key, Text value, int numPartitions) {
        AirportWritableComparable o = (AirportWritableComparable) key;
        return (o.getName().hashCode() & Integer.MAX_VALUE) % numPartitions;
    }
}
