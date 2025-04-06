package controllers;

import play.mvc.*;
import play.libs.Json;
import services.FollowService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CompletableFuture;

@Singleton
public class FollowController extends Controller {
    private final FollowService followService;

    @Inject
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> follow(Http.Request request, Long userId) {
        Long followerId = Long.parseLong(request.session().get("userId").get());
        
        if (followerId.equals(userId)) {
            return CompletableFuture.completedFuture(
                badRequest(Json.newObject().put("message", "Cannot follow yourself"))
            );
        }

        return followService.follow(followerId, userId)
            .thenApply(done -> ok(Json.newObject()
                .put("message", "Successfully followed user")));
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> unfollow(Http.Request request, Long userId) {
        Long followerId = Long.parseLong(request.session().get("userId").get());
        
        return followService.unfollow(followerId, userId)
            .thenApply(done -> ok(Json.newObject()
                .put("message", "Successfully unfollowed user")));
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> getFollowers(Http.Request request) {
        Long userId = Long.parseLong(request.session().get("userId").get());
        
        return followService.getFollowers(userId)
            .thenApply(followers -> ok(Json.toJson(followers)));
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> getFollowing(Http.Request request) {
        Long userId = Long.parseLong(request.session().get("userId").get());
        
        return followService.getFollowing(userId)
            .thenApply(following -> ok(Json.toJson(following)));
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> isFollowing(Http.Request request, Long userId) {
        Long followerId = Long.parseLong(request.session().get("userId").get());
        
        return followService.isFollowing(followerId, userId)
            .thenApply(isFollowing -> ok(Json.newObject()
                .put("isFollowing", isFollowing)));
    }
} 