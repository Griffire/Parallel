package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;


public class RouterActor extends AbstractActor {
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(dataP.class, this::executeTests)
                .match(MessageP.class, r -> storage.tell(r, sender()))
                .matchAny(o -> log.info("recieved unknown message"))
                .build();
    }
}
