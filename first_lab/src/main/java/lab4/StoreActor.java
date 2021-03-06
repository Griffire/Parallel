package lab4;
import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;

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
        ArrayList<String>  results = actorStorage.get(msg.getIdS());
        if (results != null){
            results.add(msg.getRes());
        } else {
            results = new ArrayList<>();
            results.add(msg.getRes());
            actorStorage.put(msg.getIdS(),results);
        }
    }

    private void send(MessageP msg){
        sender().tell(new MessageP(msg.getIdS(),actorStorage.get(msg.getIdS())), getContext().parent());
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageP.class, this::insert)
                .match(MessageP.class, this::send)
                .matchAny(o -> log.info("unknown res"))
                .build();    }

}
