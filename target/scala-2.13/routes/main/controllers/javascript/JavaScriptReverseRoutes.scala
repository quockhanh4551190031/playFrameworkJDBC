// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:12
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseFollowController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def follow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FollowController.follow",
      """
        function(userId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/follow/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:20
    def unfollow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FollowController.unfollow",
      """
        function(userId0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/follow/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
    // @LINE:22
    def getFollowing: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FollowController.getFollowing",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/following"})
        }
      """
    )
  
    // @LINE:21
    def getFollowers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FollowController.getFollowers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/followers"})
        }
      """
    )
  
    // @LINE:23
    def isFollowing: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FollowController.isFollowing",
      """
        function(userId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/following/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("userId", userId0))})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def follows: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.follows",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "follows"})
        }
      """
    )
  
    // @LINE:4
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.register",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:5
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:3
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseAuthController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def register: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AuthController.register",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/auth/register"})
        }
      """
    )
  
    // @LINE:9
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AuthController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/auth/login"})
        }
      """
    )
  
  }

  // @LINE:15
  class ReversePostController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getPosts: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.getPosts",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/posts"})
        }
      """
    )
  
    // @LINE:16
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PostController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/posts"})
        }
      """
    )
  
  }


}
