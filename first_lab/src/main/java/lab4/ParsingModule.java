package lab4;

import akka.actor.ActorRef;
import com.squareup.okhttp.Route;

public class ParsingModule {

    public class ParsingModule(ActorRef router) {
        this.router = router;
    }

    public Route newRouter (){
        
    }
}
