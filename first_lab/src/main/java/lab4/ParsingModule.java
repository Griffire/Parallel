package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.model.ws.Message;
import akka.http.javadsl.server.Route;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.pattern.Patterns;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import scala.concurrent.Future;
import java.util.regex.Pattern;

import static akka.http.javadsl.server.Directives.*;

import akka.util.Timeout;
import lab4.MessageP;

public class ParsingModule {
    private  ActorRef router;


    ParsingModule(ActorRef router) {
        this.router = router;
    }

    public Route newRouter (){
        Route r;
        Duration t1 = Duration.ofSeconds(5);
        Timeout t2 = Timeout.create(t1);
        MessageP ps= new MessageP("s");
        r = get(()-> parameter("", (p) -> {
            Future<Object> f = Patterns.ask(this.router, new MessageP(p), t2);
            return  completeOKWithFuture(f,Jackson.marshaller());
        })),
                post(() -> entity(Jackson.unmarshaller(PackageData.class), msg -> {
            router.tell(msg, ActorRef.noSender());
            return complete("ok");
        }))

    }
}
