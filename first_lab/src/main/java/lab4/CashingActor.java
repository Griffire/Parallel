package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

import java.util.HashMap;
import java.util.Map;

public class CashingActor extends AbstractActor {
    private LoggingAdapter log;
    private Map<String, Float> cash = new HashMap<>();

    @Override
    public Receive createReceive() {
//        return null;
        return ReceiveBuilder.create().match(String.class, msg -> sender().tell(cash.getOrDefault(msg,float( -1.0) ),
        ActorRef.noSender().m
    }
}
