package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by eric on 21/07/2017.
 */
public class PongActor extends AbstractActor{

    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);


    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("Ping", msg -> {
            log.info("recieve ping");
            sender().tell("Pong", ActorRef.noSender());
        }).matchAny(x -> {
            sender().tell( new Status.Failure(new Exception("unknown message")), self() );
        }).build();
    }
}
