package lab2;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.WritableComparable;

public class AirportWritableComparable implements WritableComparable<AirportWritableComparable> {
    // Some data
    private String name;
    private String code;

    public AirportWritableComparable(){
    }

    public AirportWritableComparable(String name , String code){
//        super();
        this.name = name;
        this.code = code;
    }

    public void write(DataOutput out) throws IOException {
        out.writeUTF(name);
        out.writeUTF(code);
    }

    public void readFields(DataInput in) throws IOException {
        name = in.readUTF();
        code = in.readUTF();
    }

//    public int compareTo(AirportWritableComparable o) {
//        int r1 =  this.name.compareTo(o.name);
//        if (r1 == 0 ){
//            return this.code.compareTo(o.code);
//        } else {
//            return r1;
//        }
//    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

//        public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result ;//  !
//        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
//        return result;
//    }
}