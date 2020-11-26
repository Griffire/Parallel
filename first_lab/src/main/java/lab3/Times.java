package lab3;

import java.io.Serializable;

public class Times implements Serializable{
    private float delay;
    private int canceled;
    private int delayN;
    private int canceledN;
    Times(){}

    Times(String time, String canceled){
        this.delay = time;


    }
}
