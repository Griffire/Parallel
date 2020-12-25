package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.marshallers.jackson.Jackson;

import java.util.concurrent.Future;

import static akka.http.javadsl.server.Directives.*;


public class ParsingModule {
    private  ActorRef router;


    ParsingModule(ActorRef router) {
        this.router = router;
    }

    public Route newRouter (){
        Route r;
        r = get(()-> parameter("", (p) -> {
            Future<Object>
        }) )
    }
}
