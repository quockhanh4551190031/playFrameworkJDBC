package services.impl;

import models.User;
import repositories.FollowRepository;
import services.FollowService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Singleton
public class FollowServiceImpl implements FollowService {
    private final FollowRepository followRepository;

    @Inject
    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public CompletionStage<Void> follow(Long followerId, Long followedId) {
        return followRepository.follow(followerId, followedId);
    }

    @Override
    public CompletionStage<Void> unfollow(Long followerId, Long followedId) {
        return followRepository.unfollow(followerId, followedId);
    }

    @Override
    public CompletionStage<List<User>> getFollowers(Long userId) {
        return followRepository.getFollowers(userId);
    }

    @Override
    public CompletionStage<List<User>> getFollowing(Long userId) {
        return followRepository.getFollowing(userId);
    }

    @Override
    public CompletionStage<Boolean> isFollowing(Long followerId, Long followedId) {
        return followRepository.isFollowing(followerId, followedId);
    }
} 