package controllers;

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import javax.inject.Inject;
import java.util.Optional;

public class Authenticated extends Security.Authenticator {
    
    @Override
    public Optional<String> getUsername(Http.Request request) {
        return request.session().get("userId");
    }

    @Override
    public Result onUnauthorized(Http.Request request) {
        return redirect(controllers.routes.HomeController.login());
    }
} 