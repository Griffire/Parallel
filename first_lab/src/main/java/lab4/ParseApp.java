package lab4;

import akka.actor.*;
import akka.*;
import akka.routing.RouterActor;


public class ParseApp {

    public static void main(String[] args) {
        Actorystem s1 = ActorSystem.create("test1");
        ActorRef routerActor = system.actorOf(Props.create(RouterActor.class), "");

    }
}
