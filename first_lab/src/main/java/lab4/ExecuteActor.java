package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class ExecuteActor  extends AbstractActor {
    public Receive createReceive() {
        return ReceiveBuilder.create().match(E)
    }
}
