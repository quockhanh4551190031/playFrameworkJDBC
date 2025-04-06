package services.impl;

import models.Post;
import models.User;
import models.Pair;
import repositories.PostRepository;
import services.PostService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Singleton
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Inject
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public CompletionStage<Post> create(Post post) {
        return postRepository.create(post);
    }

    @Override
    public CompletionStage<List<Pair<Post, User>>> getAllPostsWithUsers() {
        return postRepository.getAllPostsWithUsers();
    }
} 