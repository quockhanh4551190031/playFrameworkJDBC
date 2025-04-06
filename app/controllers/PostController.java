package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Post;
import play.libs.Json;
import play.mvc.*;
import services.PostService;
import services.FollowService;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Timestamp;
import java.util.concurrent.CompletionStage;

@Singleton
public class PostController extends Controller {
    private final PostService postService;
    private final FollowService followService;
    private final Authenticated authenticated;

    @Inject
    public PostController(PostService postService, FollowService followService, Authenticated authenticated) {
        this.postService = postService;
        this.followService = followService;
        this.authenticated = authenticated;
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> create(Http.Request request) {
        JsonNode json = request.body().asJson();
        String title = json.get("title").asText();
        String body = json.get("body").asText();
        Long userId = Long.parseLong(request.session().get("userId").get());

        Post newPost = new Post(
            null,
            title,
            body,
            userId,
            "active",
            new Timestamp(System.currentTimeMillis())
        );

        return postService.create(newPost)
            .thenApply(post -> ok(Json.newObject()
                .put("message", "Post created successfully")));
    }

    @Security.Authenticated(Authenticated.class)
    public CompletionStage<Result> getPosts(Http.Request request) {
        Long currentUserId = Long.parseLong(request.session().get("userId").get());
        
        return postService.getAllPostsWithUsers()
            .thenCompose(postsWithUsers -> {
                CompletionStage<ObjectNode> result = postsWithUsers.stream()
                    .map(pair -> followService.isFollowing(currentUserId, pair.getValue().getId())
                        .thenApply(isFollowing -> {
                            ObjectNode postData = Json.newObject();
                            postData.set("post", Json.toJson(pair.getKey()));
                            postData.set("user", Json.toJson(pair.getValue()));
                            postData.put("isFollowing", isFollowing);
                            return postData;
                        }))
                    .reduce(CompletableFuture.completedFuture(Json.newObject()),
                        (acc, next) -> acc.thenCombine(next, 
                            (objNode, newPost) -> {
                                objNode.withArray("posts").add(newPost);
                                return objNode;
                            }));
                
                return result;
            })
            .thenApply(Results::ok);
    }
} 