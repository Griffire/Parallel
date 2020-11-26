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

    public Times counting (Iterable<Times> time){
        float delaySum = (float) 0.0;
        float maxDelay = (float)0.0;
        float canceledSum = (float) 0.0;

        int n = 0;
        for (Times t : time){
            n++;
            if (t.delay > 0){
                if ( maxDelay < t.delay) {
                    maxDelay = t.delay;
                }
                delaySum += t.delay;
            }
            if (t.canceled > 0){
                canceledSum ++;
            }
        }
        Times ret = new Times( Float.toString(delaySum/(float)n) , Float.toString(canceledSum/ (float) n);
        return ret;
    }
}
