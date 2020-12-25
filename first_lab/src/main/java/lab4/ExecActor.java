package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

public class ExecActor extends AbstractActor {
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
