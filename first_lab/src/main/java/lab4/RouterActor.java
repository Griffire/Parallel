package lab4;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.japi.pf.ReceiveBuilder;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.*;

import java.util.ArrayList;
import java.util.List;

public class RouterActor extends AbstractActor {
    private LoggingAdapter log;
    private Router router;

    public RouterActor() {
        this.log = Logging.getLogger(getContext().getSystem(), self());
        List<Routee> routees = new ArrayList<>();
        int n = 3;
        for (int i = 0 ; i < n ; i++) {
            ActorRef r = getContext().actorOf(Props.create(ExecuteActor.class));
            getContext().watch(r);
            routees.add(new ActorRefRoutee(r));
        }
        this.router = new Router(new RoundRobinRoutingLogic(), routees);

    }

    private String executeTests(dataP msg) {
        ActorSystem s2 = ActorSystem.create("Execute");
        for (testP i : msg.getTests()) {
            router.route( new executeMSG(i.getParams(),msg.getIdS(),i.g)
        }

    }


        public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(dataP.class, this::executeTests)
                .match(MessageP.class, id -> sender().tell(id, self()))
                .matchAny(o -> log.info("recieved unknown message"))
                .build();
    }
}
