package controllers;

import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import play.api.mvc.RequestHeader;

@Singleton
public class HomeController extends Controller {
    
    @Inject
    public HomeController() {}

    public Result index(Http.Request request) {
        if (!request.session().get("username").isPresent()) {
            return redirect(routes.HomeController.login());
        }
        return ok(views.html.index.render(
            request.session().get("username").get(),
            asScala(request)
        )).as(Http.MimeTypes.HTML);
    }

    public Result login(Http.Request request) {
        if (request.session().get("userId").isPresent()) {
            return redirect(routes.HomeController.index());
        }
        return ok(views.html.login.render(asScala(request))).as(Http.MimeTypes.HTML);
    }

    public Result register(Http.Request request) {
        if (request.session().get("userId").isPresent()) {
            return redirect(routes.HomeController.index());
        }
        return ok(views.html.register.render(asScala(request))).as(Http.MimeTypes.HTML);
    }

    public Result logout() {
        return redirect(routes.HomeController.login())
            .withNewSession();
    }

    public Result follows(Http.Request request) {
        return ok(views.html.follows.render(
            request.session().get("username").get(),
            asScala(request)
        )).as(Http.MimeTypes.HTML);
    }

    private play.api.mvc.RequestHeader asScala(Http.Request request) {
        return request.asScala();
    }
} 