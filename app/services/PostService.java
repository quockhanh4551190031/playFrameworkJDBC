package services;

import models.Post;
import models.User;
import models.Pair;
import java.util.List;
import java.util.concurrent.CompletionStage;

public interface PostService {
    CompletionStage<Post> create(Post post);
    CompletionStage<List<Pair<Post, User>>> getAllPostsWithUsers();
} 