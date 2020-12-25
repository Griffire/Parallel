package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class RouterActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), self());

    private String executeTests(dataP msg) {
    
    }


        public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(dataP.class, msg -> sender().tell(executeTests(msg), self()))
                .match(MessageP.class, id -> sender().tell(id, self()))
                .matchAny(o -> log.info("recieved unknown message"))
                .build();
    }
}
