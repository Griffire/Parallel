package lab4;

import akka.actor.*;
import akka.event.LoggingAdapter;
import akka.http.*;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.routing.RouterActor;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import org.apache.http.protocol.HTTP;
import org.spark_project.jetty.http.HttpParser;
import akka.NotUsed;
import akka.stream.ActorMaterializer;

import java.util.concurrent.CompletionStage;

import akka.event.Logging;
import akka.event.LoggingAdapter;

public class ParseApp {


    public static void main(String[] args) throws Exception{
        ActorSystem s1 = ActorSystem.create("test1");
        LoggingAdapter log = Logging.getLogger(s1, System.out);
        log.info("Server start");
        ActorRef r1Actor = s1.actorOf(Props.create(RouterActor.class), "Router1");
        log.info("Server online ");


        Http http = Http.get(s1);
        ParsingModule PM = new ParsingModule(r1Actor);
        Materializer m1 = Materializer.createMaterializer(s1);
        Flow<HttpRequest, HttpResponse,NotUsed> r1Flow = PM.newRouter().flow(s1,m1);
        CompletionStage<ServerBinding> sBind = http.bindAndHandle(r1Flow, ConnectHttp.toHost("localhost:8888"),m1);


        //System.in.read();
        sBind.thenCompose(ServerBinding::unbind).thenAccept(unbound -> s1.terminate());
    }
}
