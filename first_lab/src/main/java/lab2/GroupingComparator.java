package lab2;


import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator {
    protected GroupComparator() {
        super(AirportWritableComparable.class, true);
    }

    @Override
    public int compare(WritableComparable w1, WritableComparable w2) {
        return w1.getName().compareTo(w2.getName());
    }
}