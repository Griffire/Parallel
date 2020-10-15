package lab2;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupComparator extends WritableComparator {
    protected GroupComparator() {
        super(AirportWritableComparable.class, true);
    }


    public int compare(AirportWritableComparable w1, AirportWritableComparable w2) {
        return w1.getName().compareTo(w2.getName());
    }
}