package services.impl;

import models.User;
import repositories.UserRepository;
import services.UserService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

@Singleton
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CompletionStage<User> create(User user) {
        return userRepository.create(user);
    }

    @Override
    public CompletionStage<Optional<User>> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
} 