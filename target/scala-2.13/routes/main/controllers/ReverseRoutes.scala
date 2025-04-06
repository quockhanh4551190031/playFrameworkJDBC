// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:12
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:19
  class ReverseFollowController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def follow(userId:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/follow/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("userId", userId)))
    }
  
    // @LINE:20
    def unfollow(userId:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/follow/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("userId", userId)))
    }
  
    // @LINE:22
    def getFollowing(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/following")
    }
  
    // @LINE:21
    def getFollowers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/followers")
    }
  
    // @LINE:23
    def isFollowing(userId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/following/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("userId", userId)))
    }
  
  }

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def follows(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "follows")
    }
  
    // @LINE:4
    def register(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:5
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:3
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:8
  class ReverseAuthController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def register(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/auth/register")
    }
  
    // @LINE:9
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/auth/login")
    }
  
  }

  // @LINE:15
  class ReversePostController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def getPosts(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/posts")
    }
  
    // @LINE:16
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/posts")
    }
  
  }


}
