
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*1.2*/import play.api.mvc.RequestHeader

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(username: String)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.53*/("""

"""),_display_(/*4.2*/main("Home")/*4.14*/ {_display_(Seq[Any](format.raw/*4.16*/("""
"""),format.raw/*5.1*/("""<div class="header">
    <h1>Welcome """),_display_(/*6.18*/username),format.raw/*6.26*/("""</h1>
    <div>
        <a href=""""),_display_(/*8.19*/routes/*8.25*/.HomeController.follows()),format.raw/*8.50*/("""" class="btn">My Network</a>
        <a href=""""),_display_(/*9.19*/routes/*9.25*/.HomeController.logout()),format.raw/*9.49*/("""" class="logout-btn">Logout</a>
    </div>
</div>

<div class="content">
    <div class="create-post">
        <h2>Create New Post</h2>
        <form id="createPostForm"
            style="display: flex; flex-direction: column; gap: 1rem; max-width: 600px; margin: 0 auto; padding: 1.5rem; background: #f5f5f5; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1);">
            """),_display_(/*18.14*/helper/*18.20*/.CSRF.formField),format.raw/*18.35*/("""
            """),format.raw/*19.13*/("""<div style="display: flex; flex-direction: column; gap: 0.5rem;">
                <label for="title" style="font-weight: 600; color: #333;">Title:</label>
                <input type="text" id="title" name="title" required
                    style="padding: 0.75rem; border: 1px solid #ddd; border-radius: 4px; font-size: 1rem;">
            </div>
            <div style="display: flex; flex-direction: column; gap: 0.5rem;">
                <label for="body" style="font-weight: 600; color: #333;">Content:</label>
                <textarea id="body" name="body" required
                    style="padding: 0.75rem; border: 1px solid #ddd; border-radius: 4px; min-height: 120px; font-size: 1rem; resize: vertical;"></textarea>
            </div>
            <button type="submit"
                style="padding: 0.75rem 1.5rem; background: #007bff; color: white; border: none; border-radius: 4px; font-size: 1rem; cursor: pointer; transition: background 0.2s; align-self: flex-start;">Create
                Post</button>
        </form>
    </div>

    <div class="posts">
        <h2>Recent Posts</h2>
        <div id="postsList"></div>
    </div>
</div>

<script>
    // Load posts
    async function loadPosts() """),format.raw/*43.32*/("""{"""),format.raw/*43.33*/("""
        """),format.raw/*44.9*/("""const token = document.querySelector('input[name="csrfToken"]').value;
        try """),format.raw/*45.13*/("""{"""),format.raw/*45.14*/("""
            """),format.raw/*46.13*/("""const response = await fetch('/api/posts', """),format.raw/*46.56*/("""{"""),format.raw/*46.57*/("""
                """),format.raw/*47.17*/("""headers: """),format.raw/*47.26*/("""{"""),format.raw/*47.27*/("""
                    """),format.raw/*48.21*/("""'Csrf-Token': token
                """),format.raw/*49.17*/("""}"""),format.raw/*49.18*/("""
            """),format.raw/*50.13*/("""}"""),format.raw/*50.14*/(""");
            const data = await response.json();
            const postsList = document.getElementById('postsList');

            postsList.innerHTML = data.posts.map(postData => `
                    <div class="post">
                        <div class="post-header">
                            <h3>Title: $"""),format.raw/*57.41*/("""{"""),format.raw/*57.42*/("""postData.post.title"""),format.raw/*57.61*/("""}"""),format.raw/*57.62*/("""</h3>
                            <div class="user-info">
                                <span class="username">Author: $"""),format.raw/*59.65*/("""{"""),format.raw/*59.66*/("""postData.user.username"""),format.raw/*59.88*/("""}"""),format.raw/*59.89*/("""</span>
                                $"""),format.raw/*60.34*/("""{"""),format.raw/*60.35*/("""postData.user.username !== '"""),_display_(/*60.64*/username),format.raw/*60.72*/("""' ?
                    `<button 
                                        onclick="toggleFollow($"""),format.raw/*62.64*/("""{"""),format.raw/*62.65*/("""postData.user.id"""),format.raw/*62.81*/("""}"""),format.raw/*62.82*/(""")" 
                                        class="follow-btn $"""),format.raw/*63.60*/("""{"""),format.raw/*63.61*/("""postData.isFollowing ? 'following' : ''"""),format.raw/*63.100*/("""}"""),format.raw/*63.101*/(""""
                                    >
                                        $"""),format.raw/*65.42*/("""{"""),format.raw/*65.43*/("""postData.isFollowing ? 'Unfollow' : 'Follow'"""),format.raw/*65.87*/("""}"""),format.raw/*65.88*/("""
                                    """),format.raw/*66.37*/("""</button>`
                    : ''
                """),format.raw/*68.17*/("""}"""),format.raw/*68.18*/("""
                            """),format.raw/*69.29*/("""</div>
                        </div>
                        <p>Content: $"""),format.raw/*71.38*/("""{"""),format.raw/*71.39*/("""postData.post.body"""),format.raw/*71.57*/("""}"""),format.raw/*71.58*/("""</p>
                        <small>Posted on $"""),format.raw/*72.43*/("""{"""),format.raw/*72.44*/("""new Date(postData.post.createdAt).toLocaleString()"""),format.raw/*72.94*/("""}"""),format.raw/*72.95*/("""</small>
                    </div>
                `).join('');
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/(""" """),format.raw/*75.11*/("""catch (error) """),format.raw/*75.25*/("""{"""),format.raw/*75.26*/("""
            """),format.raw/*76.13*/("""console.error('Error:', error);
        """),format.raw/*77.9*/("""}"""),format.raw/*77.10*/("""
    """),format.raw/*78.5*/("""}"""),format.raw/*78.6*/("""

    """),format.raw/*80.5*/("""async function toggleFollow(userId) """),format.raw/*80.41*/("""{"""),format.raw/*80.42*/("""
        """),format.raw/*81.9*/("""const token = document.querySelector('input[name="csrfToken"]').value;
        const button = event.target;
        const isFollowing = button.classList.contains('following');

        try """),format.raw/*85.13*/("""{"""),format.raw/*85.14*/("""
            """),format.raw/*86.13*/("""const response = await fetch(`/api/follow/$"""),format.raw/*86.56*/("""{"""),format.raw/*86.57*/("""userId"""),format.raw/*86.63*/("""}"""),format.raw/*86.64*/("""`, """),format.raw/*86.67*/("""{"""),format.raw/*86.68*/("""
                """),format.raw/*87.17*/("""method: isFollowing ? 'DELETE' : 'POST',
                headers: """),format.raw/*88.26*/("""{"""),format.raw/*88.27*/("""
                    """),format.raw/*89.21*/("""'Csrf-Token': token
                """),format.raw/*90.17*/("""}"""),format.raw/*90.18*/("""
            """),format.raw/*91.13*/("""}"""),format.raw/*91.14*/(""");

            if (response.ok) """),format.raw/*93.30*/("""{"""),format.raw/*93.31*/("""
                """),format.raw/*94.17*/("""button.classList.toggle('following');

                loadPosts();
            """),format.raw/*97.13*/("""}"""),format.raw/*97.14*/(""" """),format.raw/*97.15*/("""else """),format.raw/*97.20*/("""{"""),format.raw/*97.21*/("""
                """),format.raw/*98.17*/("""const error = await response.json();
                alert(error.message || 'Failed to update follow status');
            """),format.raw/*100.13*/("""}"""),format.raw/*100.14*/("""
        """),format.raw/*101.9*/("""}"""),format.raw/*101.10*/(""" """),format.raw/*101.11*/("""catch (error) """),format.raw/*101.25*/("""{"""),format.raw/*101.26*/("""
            """),format.raw/*102.13*/("""console.error('Error:', error);
            alert('Network error occurred');
        """),format.raw/*104.9*/("""}"""),format.raw/*104.10*/("""
    """),format.raw/*105.5*/("""}"""),format.raw/*105.6*/("""

    """),format.raw/*107.5*/("""// Handle post creation
    document.getElementById('createPostForm').addEventListener('submit', async (e) => """),format.raw/*108.87*/("""{"""),format.raw/*108.88*/("""
        """),format.raw/*109.9*/("""e.preventDefault();
        const token = document.querySelector('input[name="csrfToken"]').value;
        const formData = """),format.raw/*111.26*/("""{"""),format.raw/*111.27*/("""
            """),format.raw/*112.13*/("""title: document.getElementById('title').value,
            body: document.getElementById('body').value
        """),format.raw/*114.9*/("""}"""),format.raw/*114.10*/(""";

        try """),format.raw/*116.13*/("""{"""),format.raw/*116.14*/("""
            """),format.raw/*117.13*/("""const response = await fetch('/api/posts', """),format.raw/*117.56*/("""{"""),format.raw/*117.57*/("""
                """),format.raw/*118.17*/("""method: 'POST',
                headers: """),format.raw/*119.26*/("""{"""),format.raw/*119.27*/("""
                    """),format.raw/*120.21*/("""'Content-Type': 'application/json',
                    'Csrf-Token': token
                """),format.raw/*122.17*/("""}"""),format.raw/*122.18*/(""",
                body: JSON.stringify(formData)
            """),format.raw/*124.13*/("""}"""),format.raw/*124.14*/(""");

            if (response.ok) """),format.raw/*126.30*/("""{"""),format.raw/*126.31*/("""
                """),format.raw/*127.17*/("""document.getElementById('createPostForm').reset();
                loadPosts();
            """),format.raw/*129.13*/("""}"""),format.raw/*129.14*/(""" """),format.raw/*129.15*/("""else """),format.raw/*129.20*/("""{"""),format.raw/*129.21*/("""
                """),format.raw/*130.17*/("""alert('Failed to create post');
            """),format.raw/*131.13*/("""}"""),format.raw/*131.14*/("""
        """),format.raw/*132.9*/("""}"""),format.raw/*132.10*/(""" """),format.raw/*132.11*/("""catch (error) """),format.raw/*132.25*/("""{"""),format.raw/*132.26*/("""
            """),format.raw/*133.13*/("""console.error('Error:', error);
        """),format.raw/*134.9*/("""}"""),format.raw/*134.10*/("""
    """),format.raw/*135.5*/("""}"""),format.raw/*135.6*/(""");

    // Load posts when page loads
    loadPosts();
</script>
<script>
    // Load posts when page loads
    loadPosts();
</script>
""")))}))
      }
    }
  }

  def render(username:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(username)(request)

  def f:((String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (username) => (request) => apply(username)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 32ba01b2b0b970889f991e42625231dfb18a3fb7
                  MATRIX: 432->1|784->37|930->88|960->93|980->105|1019->107|1047->109|1112->148|1140->156|1202->192|1216->198|1261->223|1335->271|1349->277|1393->301|1814->695|1829->701|1865->716|1907->730|3179->1974|3208->1975|3245->1985|3357->2069|3386->2070|3428->2084|3499->2127|3528->2128|3574->2146|3611->2155|3640->2156|3690->2178|3755->2215|3784->2216|3826->2230|3855->2231|4202->2550|4231->2551|4278->2570|4307->2571|4459->2695|4488->2696|4538->2718|4567->2719|4637->2761|4666->2762|4722->2791|4751->2799|4878->2898|4907->2899|4951->2915|4980->2916|5072->2980|5101->2981|5169->3020|5199->3021|5310->3104|5339->3105|5411->3149|5440->3150|5506->3188|5588->3242|5617->3243|5675->3273|5780->3350|5809->3351|5855->3369|5884->3370|5960->3418|5989->3419|6067->3469|6096->3470|6199->3546|6228->3547|6257->3548|6299->3562|6328->3563|6370->3577|6438->3618|6467->3619|6500->3625|6528->3626|6563->3634|6627->3670|6656->3671|6693->3681|6914->3874|6943->3875|6985->3889|7056->3932|7085->3933|7119->3939|7148->3940|7179->3943|7208->3944|7254->3962|7349->4029|7378->4030|7428->4052|7493->4089|7522->4090|7564->4104|7593->4105|7656->4140|7685->4141|7731->4159|7842->4242|7871->4243|7900->4244|7933->4249|7962->4250|8008->4268|8162->4393|8192->4394|8230->4404|8260->4405|8290->4406|8333->4420|8363->4421|8406->4435|8521->4522|8551->4523|8585->4529|8614->4530|8650->4538|8790->4649|8820->4650|8858->4660|9013->4786|9043->4787|9086->4801|9227->4914|9257->4915|9303->4932|9333->4933|9376->4947|9448->4990|9478->4991|9525->5009|9596->5051|9626->5052|9677->5074|9800->5168|9830->5169|9922->5232|9952->5233|10016->5268|10046->5269|10093->5287|10216->5381|10246->5382|10276->5383|10310->5388|10340->5389|10387->5407|10461->5452|10491->5453|10529->5463|10559->5464|10589->5465|10632->5479|10662->5480|10705->5494|10774->5535|10804->5536|10838->5542|10867->5543
                  LINES: 17->1|22->2|27->2|29->4|29->4|29->4|30->5|31->6|31->6|33->8|33->8|33->8|34->9|34->9|34->9|43->18|43->18|43->18|44->19|68->43|68->43|69->44|70->45|70->45|71->46|71->46|71->46|72->47|72->47|72->47|73->48|74->49|74->49|75->50|75->50|82->57|82->57|82->57|82->57|84->59|84->59|84->59|84->59|85->60|85->60|85->60|85->60|87->62|87->62|87->62|87->62|88->63|88->63|88->63|88->63|90->65|90->65|90->65|90->65|91->66|93->68|93->68|94->69|96->71|96->71|96->71|96->71|97->72|97->72|97->72|97->72|100->75|100->75|100->75|100->75|100->75|101->76|102->77|102->77|103->78|103->78|105->80|105->80|105->80|106->81|110->85|110->85|111->86|111->86|111->86|111->86|111->86|111->86|111->86|112->87|113->88|113->88|114->89|115->90|115->90|116->91|116->91|118->93|118->93|119->94|122->97|122->97|122->97|122->97|122->97|123->98|125->100|125->100|126->101|126->101|126->101|126->101|126->101|127->102|129->104|129->104|130->105|130->105|132->107|133->108|133->108|134->109|136->111|136->111|137->112|139->114|139->114|141->116|141->116|142->117|142->117|142->117|143->118|144->119|144->119|145->120|147->122|147->122|149->124|149->124|151->126|151->126|152->127|154->129|154->129|154->129|154->129|154->129|155->130|156->131|156->131|157->132|157->132|157->132|157->132|157->132|158->133|159->134|159->134|160->135|160->135
                  -- GENERATED --
              */
          