package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class RouterActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), self());

    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(dataP.class, this::ex)
                .match(MessageP.class, r -> storage.tell(r, sender()))
                .matchAny(o -> log.info("recieved unknown message"))
                .build();
    }
}
