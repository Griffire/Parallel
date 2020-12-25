package lab4;

import akka.actor.ActorSystem;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class NetworkApp {
    public static void main(String[] args) {
        ActorSystem s1 = ActorSystem.create("test4");
        LoggingAdapter log = Logging.getLogger(s1, System.out);
        log.info("Server start");

    }
}
