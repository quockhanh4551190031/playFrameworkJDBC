package services;

import models.User;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

public interface UserService {
    CompletionStage<User> create(User user);
    CompletionStage<Optional<User>> findByUsername(String username);
} 