package lab4;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class ExecActor extends AbstractActor {


    private String execute(executeMSG msg) {
        String result;
        try {
            ScriptEngine e = new ScriptEngineManager().getEngineByName("nashorn");
            e.eval(msg.getJsS());
            Invocable in = (Invocable) e;
            result = in.invokeFunction(msg.getFunction(), msg.getParams().toArray()).toString();
        }
        catch (Exception e) {
            return String.format("%s: ERROR, %s", r.getTestName(), e.toString());
        }
            if (result.equals(msg.getTestExResult()))
                return String.format("%s: OK, result: %s", msg.getTestName(), result);
            else
                return String.format("%s: FAIL, expected: %s, got: %s", msg.getTestName(), msg.getTestExResult(), result);
    }

    private void send(executeMSG msg){
        sender().tell(new MessageP(msg.getIdS(),execute(msg)), getContext().parent());
    }

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageP.class, this::insert)
                .match(MessageP.class, this::send)
                .matchAny(o -> log.info("unknown res"))
                .build();    }
}
