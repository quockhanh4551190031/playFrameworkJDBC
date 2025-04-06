// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  HomeController_4: controllers.HomeController,
  // @LINE:8
  AuthController_1: controllers.AuthController,
  // @LINE:12
  Assets_2: controllers.Assets,
  // @LINE:15
  PostController_0: controllers.PostController,
  // @LINE:19
  FollowController_3: controllers.FollowController,
  val prefix: String
) extends GeneratedRouter {

  @javax.inject.Inject()
  def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    HomeController_4: controllers.HomeController,
    // @LINE:8
    AuthController_1: controllers.AuthController,
    // @LINE:12
    Assets_2: controllers.Assets,
    // @LINE:15
    PostController_0: controllers.PostController,
    // @LINE:19
    FollowController_3: controllers.FollowController
  ) = this(errorHandler, HomeController_4, AuthController_1, Assets_2, PostController_0, FollowController_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_4, AuthController_1, Assets_2, PostController_0, FollowController_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.HomeController.login(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.HomeController.register(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.HomeController.logout()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/auth/register""", """controllers.AuthController.register(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/auth/login""", """controllers.AuthController.login(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/posts""", """controllers.PostController.getPosts(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/posts""", """controllers.PostController.create(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/follow/""" + "$" + """userId<[^/]+>""", """controllers.FollowController.follow(request:Request, userId:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/follow/""" + "$" + """userId<[^/]+>""", """controllers.FollowController.unfollow(request:Request, userId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/followers""", """controllers.FollowController.getFollowers(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/following""", """controllers.FollowController.getFollowing(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/following/""" + "$" + """userId<[^/]+>""", """controllers.FollowController.isFollowing(request:Request, userId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """follows""", """controllers.HomeController.follows(request:Request)"""),
    Nil
  ).foldLeft(Seq.empty[(String, String, String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String, String, String)]
    case l => s ++ l.asInstanceOf[List[(String, String, String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_4.index(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_HomeController_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_HomeController_login1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_4.login(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "login",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_HomeController_register2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_HomeController_register2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_4.register(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "register",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_HomeController_logout3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_HomeController_logout3_invoker = createInvoker(
    HomeController_4.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_AuthController_register4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/auth/register")))
  )
  private[this] lazy val controllers_AuthController_register4_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AuthController_1.register(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthController",
      "register",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/auth/register""",
      """ Auth API""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_AuthController_login5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/auth/login")))
  )
  private[this] lazy val controllers_AuthController_login5_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      AuthController_1.login(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AuthController",
      "login",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/auth/login""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_PostController_getPosts7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/posts")))
  )
  private[this] lazy val controllers_PostController_getPosts7_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PostController_0.getPosts(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "getPosts",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """api/posts""",
      """ Posts API""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PostController_create8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/posts")))
  )
  private[this] lazy val controllers_PostController_create8_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PostController_0.create(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PostController",
      "create",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """api/posts""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_FollowController_follow9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/follow/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FollowController_follow9_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      FollowController_3.follow(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FollowController",
      "follow",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "POST",
      this.prefix + """api/follow/""" + "$" + """userId<[^/]+>""",
      """ Follow API""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_FollowController_unfollow10_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/follow/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FollowController_unfollow10_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      FollowController_3.unfollow(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FollowController",
      "unfollow",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "DELETE",
      this.prefix + """api/follow/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_FollowController_getFollowers11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/followers")))
  )
  private[this] lazy val controllers_FollowController_getFollowers11_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      FollowController_3.getFollowers(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FollowController",
      "getFollowers",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """api/followers""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_FollowController_getFollowing12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/following")))
  )
  private[this] lazy val controllers_FollowController_getFollowing12_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      FollowController_3.getFollowing(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FollowController",
      "getFollowing",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """api/following""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_FollowController_isFollowing13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/following/"), DynamicPart("userId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FollowController_isFollowing13_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      FollowController_3.isFollowing(fakeValue[play.mvc.Http.Request], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FollowController",
      "isFollowing",
      Seq(classOf[play.mvc.Http.Request], classOf[Long]),
      "GET",
      this.prefix + """api/following/""" + "$" + """userId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_HomeController_follows14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("follows")))
  )
  private[this] lazy val controllers_HomeController_follows14_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_4.follows(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "follows",
      Seq(classOf[play.mvc.Http.Request]),
      "GET",
      this.prefix + """follows""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(
          req => HomeController_4.index(req))
      }
  
    // @LINE:3
    case controllers_HomeController_login1_route(params@_) =>
      call { 
        controllers_HomeController_login1_invoker.call(
          req => HomeController_4.login(req))
      }
  
    // @LINE:4
    case controllers_HomeController_register2_route(params@_) =>
      call { 
        controllers_HomeController_register2_invoker.call(
          req => HomeController_4.register(req))
      }
  
    // @LINE:5
    case controllers_HomeController_logout3_route(params@_) =>
      call { 
        controllers_HomeController_logout3_invoker.call(HomeController_4.logout())
      }
  
    // @LINE:8
    case controllers_AuthController_register4_route(params@_) =>
      call { 
        controllers_AuthController_register4_invoker.call(
          req => AuthController_1.register(req))
      }
  
    // @LINE:9
    case controllers_AuthController_login5_route(params@_) =>
      call { 
        controllers_AuthController_login5_invoker.call(
          req => AuthController_1.login(req))
      }
  
    // @LINE:12
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:15
    case controllers_PostController_getPosts7_route(params@_) =>
      call { 
        controllers_PostController_getPosts7_invoker.call(
          req => PostController_0.getPosts(req))
      }
  
    // @LINE:16
    case controllers_PostController_create8_route(params@_) =>
      call { 
        controllers_PostController_create8_invoker.call(
          req => PostController_0.create(req))
      }
  
    // @LINE:19
    case controllers_FollowController_follow9_route(params@_) =>
      call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_FollowController_follow9_invoker.call(
          req => FollowController_3.follow(req, userId))
      }
  
    // @LINE:20
    case controllers_FollowController_unfollow10_route(params@_) =>
      call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_FollowController_unfollow10_invoker.call(
          req => FollowController_3.unfollow(req, userId))
      }
  
    // @LINE:21
    case controllers_FollowController_getFollowers11_route(params@_) =>
      call { 
        controllers_FollowController_getFollowers11_invoker.call(
          req => FollowController_3.getFollowers(req))
      }
  
    // @LINE:22
    case controllers_FollowController_getFollowing12_route(params@_) =>
      call { 
        controllers_FollowController_getFollowing12_invoker.call(
          req => FollowController_3.getFollowing(req))
      }
  
    // @LINE:23
    case controllers_FollowController_isFollowing13_route(params@_) =>
      call(params.fromPath[Long]("userId", None)) { (userId) =>
        controllers_FollowController_isFollowing13_invoker.call(
          req => FollowController_3.isFollowing(req, userId))
      }
  
    // @LINE:24
    case controllers_HomeController_follows14_route(params@_) =>
      call { 
        controllers_HomeController_follows14_invoker.call(
          req => HomeController_4.follows(req))
      }
  }
}
