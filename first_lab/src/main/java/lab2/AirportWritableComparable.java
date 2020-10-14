package lab2;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

public class AirportWritableComparable implements WritableComparable {
    // Some data
    private String name;
    private String code;

    public AirportWritableComparable(){
    }

    public AirportWritableComparable(String name , String code){
        this.name = name;
        this.code = code;
    }

    public void write(DataOutput out) throws IOException {
        out.writeString(name);
        out.writeString(code);
    }

    public void readFields(DataInput in) throws IOException {
        name = in.readString();
        code = in.readString();
    }

    public int compareTo(MyWritableComparable o) {
        int r1 =  this.name.compareTo(o.name);
        if (r1 == 0){
            return this.code.compareTo(o.code);
        } else {
            return r1;
        }
    }

//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + name;//  !
//        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
//        return result
//    }
}