package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.User;
import play.libs.Json;
import play.mvc.*;
import services.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.Timestamp;
import java.util.concurrent.CompletionStage;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Singleton
public class AuthController extends Controller {
    private final UserService userService;

    @Inject
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public CompletionStage<Result> register(Http.Request request) {
        JsonNode json = request.body().asJson();
        String username = json.get("username").asText();
        String password = json.get("password").asText();

        return userService.findByUsername(username)
            .thenCompose(optionalUser -> {
                if (optionalUser.isPresent()) {
                    // Username already exists
                    return CompletableFuture.completedFuture(
                        badRequest(Json.newObject()
                            .put("message", "Username already exists"))
                    );
                } else {
                    // Username is available, proceed with registration
                    User newUser = new User(
                        null,
                        username,
                        password, 
                        "user",
                        new Timestamp(System.currentTimeMillis())
                    );

                    return userService.create(newUser)
                        .thenApply(user -> ok(Json.newObject()
                            .put("message", "User registered successfully")));
                }
            });
    }

    public CompletionStage<Result> login(Http.Request request) {
        JsonNode json = request.body().asJson();
        String username = json.get("username").asText();
        String password = json.get("password").asText();

        return userService.findByUsername(username)
            .thenApply(optionalUser -> {
                if (optionalUser.isPresent() && 
                    optionalUser.get().getPassword().equals(password)) {
                    User user = optionalUser.get();
                    return ok(Json.newObject()
                        .put("message", "Login successful"))
                        .addingToSession(request, 
                            Map.of("userId", user.getId().toString(),
                                   "username", user.getUsername()));
                } else {
                    return badRequest(Json.newObject()
                        .put("message", "Invalid credentials"));
                }
            });
    }
} 