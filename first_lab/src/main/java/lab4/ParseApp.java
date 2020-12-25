package lab4;

import akka.actor.*;
import akka.*;
import akka.routing.RouterActor;


public class ParseApp {

    public static void main(String[] args) throws Exception{
        ActorSystem s1 = ActorSystem.create("test1");
        ActorRef routerActor = s1.actorOf(Props.create(RouterActor.class), "");

    }
}
