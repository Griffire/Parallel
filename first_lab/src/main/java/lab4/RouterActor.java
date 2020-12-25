package lab4;

import akka.actor.AbstractActor;

public class RouterActor extends AbstractActor {
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(.class, this::executeTests)
                .match(MessageP.class, r -> storage.tell(r, sender()))
                .matchAny(o -> log.info("recieved unknown message"))
                .build();
    }
}
