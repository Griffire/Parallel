package lab4;

import akka.actor.ActorRef;
import akka.http.javadsl.server.Route;

public class ParsingModule {
    private  ActorRef router;


    ParsingModule(ActorRef router) {
        this.router = router;
    }

    public Route newRouter (){
        Route r;
        r = 
    }
}
