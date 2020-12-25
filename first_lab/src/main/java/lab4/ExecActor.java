package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class ExecActor extends AbstractActor {


    private String execute(executeMSG msg) {
        ScriptEngine e = new ScriptEngineManager().getEngineByName("nashorn");
        e.eval(msg.getJsS());
        Invocable in = (Invocable) e;
        String result = in.invokeFunction(msg.getFunction(), msg.getParams().toArray()).toString();

        catch (Exception e) {
            return String.format("%s: ERROR, %s", r.getTestName(), e.toString());
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
