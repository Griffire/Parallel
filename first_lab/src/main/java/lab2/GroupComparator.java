package lab2;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupComparator extends WritableComparator {
    protected GroupComparator() {
//        super(AirportWritableComparable.class, true);
    }


    public int compare(WritableComparable w1, WritableComparable w2) {
        AirportWritableComparable o1 = (AirportWritableComparable) w1;
        AirportWritableComparable o2 = (AirportWritableComparable) w2;

        return o1.getName().compareTo(o2.getName());
    }
}