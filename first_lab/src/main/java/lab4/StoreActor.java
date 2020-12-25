package lab4;
import akka.actor.AbstractActor;
import akka.event.LoggingAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StoreActor extends AbstractActor {
    private LoggingAdapter log;
    private Map<String, ArrayList<String>> actorStorage = new HashMap<>();


    public StoreActor(LoggingAdapter log, Map<String, ArrayList<String>> actorStorage) {
        this.log = log;
        this.actorStorage = actorStorage;
    }
}
