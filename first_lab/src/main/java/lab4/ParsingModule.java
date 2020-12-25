package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.pattern.Patterns;
import okio.Timeout;

import java.time.Duration;
import java.util.concurrent.Future;
import java.util.regex.Pattern;

import static akka.http.javadsl.server.Directives.*;


public class ParsingModule {
    private  ActorRef router;


    ParsingModule(ActorRef router) {
        this.router = router;
    }

    public Route newRouter (){
        Route r;
        Duration t1 = Duration.ofSeconds(5);
        r = get(()-> parameter("", (p) -> {
            Future<Object> f = Patterns.ask(this.router, p , t1);
            return  completeOKWithFuture(f,Jackson.marshaller())
        }) )
    }
}
