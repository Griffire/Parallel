package lab4;

import akka.actor.AbstractActor;
import akka.event.LoggingAdapter;

import java.util.HashMap;
import java.util.Map;

public class CashingActor extends AbstractActor {
    private LoggingAdapter log;
    private Map<String, Float> cash = new HashMap<>();

    @Override
    public Receive createReceive() {
//        return null;
        return 
    }
}
