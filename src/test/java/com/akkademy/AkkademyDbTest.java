package com.akkademy;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by eric on 21/07/2017.
 */
public class AkkademyDbTest {

    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap(){
        TestActorRef<AkkademyDb> actorRef = TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(new SetRequest("aa", "testss"), ActorRef.noSender());
        AkkademyDb akkademyDb = actorRef.underlyingActor();
        assertEquals(akkademyDb.map.get("aa"), "testss");
    }

}
