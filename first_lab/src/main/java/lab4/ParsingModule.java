package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.pattern.Patterns;
import java.time.Duration;
import scala.concurrent.Future;
import static akka.http.javadsl.server.Directives.*;
import akka.util.Timeout;


public class ParsingModule {
    private  ActorRef router;


    ParsingModule(ActorRef router) {
        this.router = router;
    }

    public Route newRouter (){
        System.out.println("router");
        Route r1 , r2;
        Duration t1 = Duration.ofSeconds(5);
        Timeout t2 = Timeout.create(t1);
        MessageP ps= new MessageP("s");

        r1 = get(()-> parameter("", (p) -> {
            Future<Object> f = Patterns.ask(this.router, new MessageP(p), t2);
            return  completeOKWithFuture(f,Jackson.marshaller());
        }));

        r2 = post(() -> entity(Jackson.unmarshaller(dataP.class), msg -> {
            router.tell(msg, ActorRef.noSender());
            return complete("ok");
        }));
        return route(r1,r2);
    }
}
