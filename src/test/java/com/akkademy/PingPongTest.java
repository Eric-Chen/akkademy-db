package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.Props;
import org.junit.Assert;
import org.junit.Test;
import scala.concurrent.Future;

import java.util.concurrent.*;

import static akka.pattern.Patterns.ask;
import static scala.compat.java8.FutureConverters.toJava;
/**
 * Created by eric on 21/07/2017.
 */
public class PingPongTest extends AbstractBasicTest {

    @Test
    public void test_pingpong() throws InterruptedException, ExecutionException, TimeoutException {
        ActorRef actorRef = system.actorOf(Props.create(PongActor.class));
        Future sfuture = ask(actorRef, "Ping", 1000);
        final CompletionStage<String> cs = toJava(sfuture);
        final CompletableFuture<String> jfuture = (CompletableFuture<String>) cs;
        cs.thenAccept(x -> System.out.println(x));

        Assert.assertEquals(jfuture.get(1000, TimeUnit.MILLISECONDS), "Pong");

    }

}
