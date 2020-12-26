package lab4;

import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.japi.Pair;
import akka.routing.RouterActor;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;

import java.util.concurrent.CompletionStage;

public class NetworkApp {

    static Flow<HttpRequest, HttpResponse, NotUsed> createFlow(ActorMaterializer m1, ActorRef act){
        Flow r;
        r = Flow.of(HttpRequest.class).map(o -> {
            return new Pair<>(o.getUri().query().getOrElse(url,host),o.getUri().query().getOrElse(COUNT, "1") );
        }).mapAsync(2, (Pair<String,Integer> pair) -> );
    }


    public static void main(String[] args) {
        ActorSystem s1 = ActorSystem.create("test4");
        LoggingAdapter log = Logging.getLogger(s1, System.out);
        log.info("Server start");
        ActorRef r1Actor = s1.actorOf(Props.create(CashingActor.class), "CashRouter");
        log.info("Server online ");


        Http http = Http.get(s1);
        ParsingModule PM = new ParsingModule(r1Actor);
        Materializer m1 = Materializer.createMaterializer(s1);
//        Flow<HttpRequest, HttpResponse, NotUsed> r1Flow = PM.newRouter().flow(s1,m1);
        Flow<HttpRequest, HttpResponse, NotUsed> r1Flow = createFlow(m1, CashingActor);
        CompletionStage<ServerBinding> sBind = http.bindAndHandle(r1Flow, ConnectHttp.toHost("localhost:8888"),m1);


        //System.in.read();
        sBind.thenCompose(ServerBinding::unbind).thenAccept(unbound -> s1.terminate());
    }





}
