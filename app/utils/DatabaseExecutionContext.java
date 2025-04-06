package utils;

import play.libs.concurrent.CustomExecutionContext;
import akka.actor.ActorSystem;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DatabaseExecutionContext extends CustomExecutionContext {
    
    @Inject
    public DatabaseExecutionContext(ActorSystem actorSystem) {
        super(actorSystem, "database.dispatcher");
    }
} 