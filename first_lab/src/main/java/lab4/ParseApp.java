package lab4;

import akka.actor.*;
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


public class ParseApp {

    public static void main(String[] args) throws Exception{
        ActorSystem s1 = ActorSystem.create("test1");
        ActorRef r1Actor = s1.actorOf(Props.create(RouterActor.class), "Router1");
        Http http = Http.get(s1);
        ParsingModule PM = new ParsingModule(r1Actor);
        Materializer m1 = Materializer.createMaterializer(s1);
        Flow<HttpRequest, HttpResponse,NotUsed> r1Flow = PM.newRouter().flow(s1,m1);
        CompletionStage<ServerBinding> sBind = http.bindAndHandle(r1Flow, ConnectHttp.toHost("localhost:8888"),m1);
    }
}
