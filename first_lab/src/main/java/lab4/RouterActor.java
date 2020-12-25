package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.japi.pf.ReceiveBuilder;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.BalancingPool;

public class RouterActor extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), self());

    private String executeTests(dataP msg) {
        ActorSystem s2 = ActorSystem.create("Execute");
        ActorRef exAct = s2.actorOf(new BalancingPool(4).props())

    }


        public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(dataP.class, msg -> sender().tell(executeTests(msg), self()))
                .match(MessageP.class, id -> sender().tell(id, self()))
                .matchAny(o -> log.info("recieved unknown message"))
                .build();
    }
}
