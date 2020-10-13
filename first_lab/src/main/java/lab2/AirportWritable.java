package lab3;

import org.apache.hadoop.io.*;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class AirportWritable implements Writable<AirportWritable>{
//    private int YEAR, QUARTER, MONTH , DAY_OF_MONTH   ;
//    private long timestamp;
//
////    public void write(DataOutput out) throws IOException {
////        out.writeInt(counter);
////        out.writeLong(timestamp);
////    }
//
//
//
//    public void readFields(DataInput in) throws IOException {
////        YEAR = in.readInt();
////        QUARTER = in.readInt();
////        MONTH = in.readInt();
////        DAY_OF_MONTH = in.readInt();
////        DAY_OF_WEEK = in.readInt();
////        FL_DATE = in.readUTF();
////        UNIQUE_CARRIER = in.readString();
////        AIRLINE_ID = in.readInt();
////        CARRIER = in.readString();
////        TAIL_NUM = in.readString();
////        FL_NUM = in.readString();
////        ORIGIN_AIRPORT_ID = in.readInt();
////        ORIGIN_AIRPORT_SEQ_ID = in.readInt();
////        ORIGIN_CITY_MARKET_ID = in.readInt();
////        DEST_AEROPORT_ID = in.readInt();
////        WHEELS_ON = in.readString();
////        ARR_TIME = in.readString();
////        ARR_DELAY = in.readFloat();
////        ARR_DELAY_NEW = in.readFloat();
////        CANCELLED = in.readFloat();
////        CANCELLATION_CODE = in.readString();
////        AIR_TIME = in.readFloat();
////        DISTANCE = in.readFloat();
//    }
//
//    public static MyWritable read(DataInput in) throws IOException {
//        MyWritable w = new MyWritable();
//        w.readFields(in);
//        return w;
//    }
}