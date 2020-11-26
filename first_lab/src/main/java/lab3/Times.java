package lab3;

import java.io.Serializable;

public class Times implements Serializable{
    private float delay;
    private float canceled;
    private int delayN;
    private int canceledN;
    Times(){}

    Times(String time, String canceled){
        this.delay = Float.parseFloat(time);
        this.canceled = Float.parseFloat(canceled);
        this.delayN = 1;
        this.canceledN = 1;
    }

    public Times counting 
}
