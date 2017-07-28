package com.akkademy;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eric on 21/07/2017.
 */
public class AkkademyDb extends AbstractActor {

    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);

    protected final Map<String, Object> map = new HashMap<>();

    public AkkademyDb() {
    }

    public AkkademyDb(String nothing) {
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(SetRequest.class, message -> {
                    log.info("Received set request – key: {} value: {}", message.getKey(), message.getValue());
                    map.put(message.getKey(), message.getValue());
                })
                .match(GetRequest.class, message -> {
                    Object value = map.get(message.key);
                    Object result = value != null ? value : new Status.Failure(new KeyNotFoundException(message.key));
                    sender().tell(result, self());
                })
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }
}

