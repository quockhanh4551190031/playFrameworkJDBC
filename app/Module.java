package modules;

import com.google.inject.AbstractModule;
import services.*;
import services.impl.*;

public class Module extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserService.class).to(UserServiceImpl.class);
        bind(PostService.class).to(PostServiceImpl.class);
        bind(FollowService.class).to(FollowServiceImpl.class);
    }
} 