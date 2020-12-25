package lab4;
import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class StoreActor extends AbstractActor {
    private LoggingAdapter log;
    private Map<String, ArrayList<String>> actorStorage;


    public StoreActor() {
        this.log = Logging.getLogger(getContext().getSystem(), self());;
        this.actorStorage =  new HashMap<>();
    }

    private void insert(MessageP msg){
        ArrayList<String>  results = actorStorage.
    }
}
