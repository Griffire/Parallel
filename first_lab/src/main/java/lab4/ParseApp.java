package lab4;

import akka.actor.*;
import akka.http.*;
import akka.routing.RouterActor;
import org.apache.http.protocol.HTTP;


public class ParseApp {

    public static void main(String[] args) throws Exception{
        ActorSystem s1 = ActorSystem.create("test1");
        ActorRef routerActor = s1.actorOf(Props.create(RouterActor.class), "Router1");
        HTTP http = Http.get(s1);


    }
}
