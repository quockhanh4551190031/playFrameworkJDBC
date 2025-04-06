package services;

import models.User;
import java.util.List;
import java.util.concurrent.CompletionStage;

public interface FollowService {
    CompletionStage<Void> follow(Long followerId, Long followedId);
    CompletionStage<Void> unfollow(Long followerId, Long followedId);
    CompletionStage<List<User>> getFollowers(Long userId);
    CompletionStage<List<User>> getFollowing(Long userId);
    CompletionStage<Boolean> isFollowing(Long followerId, Long followedId);
} 