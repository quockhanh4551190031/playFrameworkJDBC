
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

object follows extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(username: String)(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.53*/("""

"""),_display_(/*4.2*/main("Follows")/*4.17*/ {_display_(Seq[Any](format.raw/*4.19*/("""
    """),format.raw/*5.5*/("""<div class="header">
        <h1>"""),_display_(/*6.14*/username),format.raw/*6.22*/("""'s Network</h1>
        <div>
            <a href=""""),_display_(/*8.23*/routes/*8.29*/.HomeController.index()),format.raw/*8.52*/("""" class="btn">Home</a>
            <a href=""""),_display_(/*9.23*/routes/*9.29*/.HomeController.logout()),format.raw/*9.53*/("""" class="logout-btn">Logout</a>
        </div>
    </div>

    <div class="content">
        """),_display_(/*14.10*/helper/*14.16*/.CSRF.formField),format.raw/*14.31*/("""
        """),format.raw/*15.9*/("""<div class="follows-container">
            <div class="followers-section">
                <h2>Followers</h2>
                <div id="followersList" class="users-list"></div>
            </div>
            <div class="following-section">
                <h2>Following</h2>
                <div id="followingList" class="users-list"></div>
            </div>
        </div>
    </div>

    <script>
        async function loadFollowers() """),format.raw/*28.40*/("""{"""),format.raw/*28.41*/("""
            """),format.raw/*29.13*/("""const token = document.querySelector('input[name="csrfToken"]').value;
            try """),format.raw/*30.17*/("""{"""),format.raw/*30.18*/("""
                """),format.raw/*31.17*/("""const response = await fetch('/api/followers', """),format.raw/*31.64*/("""{"""),format.raw/*31.65*/("""
                    """),format.raw/*32.21*/("""headers: """),format.raw/*32.30*/("""{"""),format.raw/*32.31*/("""
                        """),format.raw/*33.25*/("""'Csrf-Token': token
                    """),format.raw/*34.21*/("""}"""),format.raw/*34.22*/("""
                """),format.raw/*35.17*/("""}"""),format.raw/*35.18*/(""");
                const followers = await response.json();
                console.log(followers);
                const followersList = document.getElementById('followersList');
                followersList.innerHTML = followers.map(user => `
                    <div class="user-item">
                        <span class="username">$"""),format.raw/*41.49*/("""{"""),format.raw/*41.50*/("""user.username"""),format.raw/*41.63*/("""}"""),format.raw/*41.64*/("""</span>
                    </div>
                `).join('');
            """),format.raw/*44.13*/("""}"""),format.raw/*44.14*/(""" """),format.raw/*44.15*/("""catch (error) """),format.raw/*44.29*/("""{"""),format.raw/*44.30*/("""
                """),format.raw/*45.17*/("""console.error('Error loading followers:', error);
            """),format.raw/*46.13*/("""}"""),format.raw/*46.14*/("""
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""

        """),format.raw/*49.9*/("""async function loadFollowing() """),format.raw/*49.40*/("""{"""),format.raw/*49.41*/("""
            """),format.raw/*50.13*/("""const token = document.querySelector('input[name="csrfToken"]').value;
            try """),format.raw/*51.17*/("""{"""),format.raw/*51.18*/("""
                """),format.raw/*52.17*/("""const response = await fetch('/api/following', """),format.raw/*52.64*/("""{"""),format.raw/*52.65*/("""
                    """),format.raw/*53.21*/("""headers: """),format.raw/*53.30*/("""{"""),format.raw/*53.31*/("""
                        """),format.raw/*54.25*/("""'Csrf-Token': token
                    """),format.raw/*55.21*/("""}"""),format.raw/*55.22*/("""
                """),format.raw/*56.17*/("""}"""),format.raw/*56.18*/(""");
                const following = await response.json();
                const followingList = document.getElementById('followingList');
                followingList.innerHTML = following.map(user => `
                    <div class="user-item">
                        <span class="username">$"""),format.raw/*61.49*/("""{"""),format.raw/*61.50*/("""user.username"""),format.raw/*61.63*/("""}"""),format.raw/*61.64*/("""</span>
                        <button onclick="unfollowUser($"""),format.raw/*62.56*/("""{"""),format.raw/*62.57*/("""user.id"""),format.raw/*62.64*/("""}"""),format.raw/*62.65*/(""")" class="unfollow-btn">Unfollow</button>
                    </div>
                `).join('');
            """),format.raw/*65.13*/("""}"""),format.raw/*65.14*/(""" """),format.raw/*65.15*/("""catch (error) """),format.raw/*65.29*/("""{"""),format.raw/*65.30*/("""
                """),format.raw/*66.17*/("""console.error('Error loading following:', error);
            """),format.raw/*67.13*/("""}"""),format.raw/*67.14*/("""
        """),format.raw/*68.9*/("""}"""),format.raw/*68.10*/("""

        """),format.raw/*70.9*/("""async function unfollowUser(userId) """),format.raw/*70.45*/("""{"""),format.raw/*70.46*/("""
            """),format.raw/*71.13*/("""const token = document.querySelector('input[name="csrfToken"]').value;
            try """),format.raw/*72.17*/("""{"""),format.raw/*72.18*/("""
                """),format.raw/*73.17*/("""const response = await fetch(`/api/follow/$"""),format.raw/*73.60*/("""{"""),format.raw/*73.61*/("""userId"""),format.raw/*73.67*/("""}"""),format.raw/*73.68*/("""`, """),format.raw/*73.71*/("""{"""),format.raw/*73.72*/("""
                    """),format.raw/*74.21*/("""method: 'DELETE',
                    headers: """),format.raw/*75.30*/("""{"""),format.raw/*75.31*/("""
                        """),format.raw/*76.25*/("""'Csrf-Token': token
                    """),format.raw/*77.21*/("""}"""),format.raw/*77.22*/("""
                """),format.raw/*78.17*/("""}"""),format.raw/*78.18*/(""");

                if (response.ok) """),format.raw/*80.34*/("""{"""),format.raw/*80.35*/("""
                    """),format.raw/*81.21*/("""loadFollowing();
                """),format.raw/*82.17*/("""}"""),format.raw/*82.18*/(""" """),format.raw/*82.19*/("""else """),format.raw/*82.24*/("""{"""),format.raw/*82.25*/("""
                    """),format.raw/*83.21*/("""alert('Failed to unfollow user');
                """),format.raw/*84.17*/("""}"""),format.raw/*84.18*/("""
            """),format.raw/*85.13*/("""}"""),format.raw/*85.14*/(""" """),format.raw/*85.15*/("""catch (error) """),format.raw/*85.29*/("""{"""),format.raw/*85.30*/("""
                """),format.raw/*86.17*/("""console.error('Error:', error);
            """),format.raw/*87.13*/("""}"""),format.raw/*87.14*/("""
        """),format.raw/*88.9*/("""}"""),format.raw/*88.10*/("""

        """),format.raw/*90.9*/("""loadFollowers();
        loadFollowing();
    </script>
""")))}),format.raw/*93.2*/(""" """))
      }
    }
  }

  def render(username:String,request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(username)(request)

  def f:((String) => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (username) => (request) => apply(username)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/follows.scala.html
                  HASH: 56763c50b8f5a71362b4a3f7b6bd2aecfcea778a
                  MATRIX: 432->1|786->37|932->88|962->93|985->108|1024->110|1056->116|1117->151|1145->159|1225->213|1239->219|1282->242|1354->288|1368->294|1412->318|1538->417|1553->423|1589->438|1626->448|2106->900|2135->901|2177->915|2293->1003|2322->1004|2368->1022|2443->1069|2472->1070|2522->1092|2559->1101|2588->1102|2642->1128|2711->1169|2740->1170|2786->1188|2815->1189|3187->1533|3216->1534|3257->1547|3286->1548|3393->1627|3422->1628|3451->1629|3493->1643|3522->1644|3568->1662|3659->1725|3688->1726|3725->1736|3754->1737|3793->1749|3852->1780|3881->1781|3923->1795|4039->1883|4068->1884|4114->1902|4189->1949|4218->1950|4268->1972|4305->1981|4334->1982|4388->2008|4457->2049|4486->2050|4532->2068|4561->2069|4892->2372|4921->2373|4962->2386|4991->2387|5083->2451|5112->2452|5147->2459|5176->2460|5317->2573|5346->2574|5375->2575|5417->2589|5446->2590|5492->2608|5583->2671|5612->2672|5649->2682|5678->2683|5717->2695|5781->2731|5810->2732|5852->2746|5968->2834|5997->2835|6043->2853|6114->2896|6143->2897|6177->2903|6206->2904|6237->2907|6266->2908|6316->2930|6392->2978|6421->2979|6475->3005|6544->3046|6573->3047|6619->3065|6648->3066|6715->3105|6744->3106|6794->3128|6856->3162|6885->3163|6914->3164|6947->3169|6976->3170|7026->3192|7105->3243|7134->3244|7176->3258|7205->3259|7234->3260|7276->3274|7305->3275|7351->3293|7424->3338|7453->3339|7490->3349|7519->3350|7558->3362|7648->3422
                  LINES: 17->1|22->2|27->2|29->4|29->4|29->4|30->5|31->6|31->6|33->8|33->8|33->8|34->9|34->9|34->9|39->14|39->14|39->14|40->15|53->28|53->28|54->29|55->30|55->30|56->31|56->31|56->31|57->32|57->32|57->32|58->33|59->34|59->34|60->35|60->35|66->41|66->41|66->41|66->41|69->44|69->44|69->44|69->44|69->44|70->45|71->46|71->46|72->47|72->47|74->49|74->49|74->49|75->50|76->51|76->51|77->52|77->52|77->52|78->53|78->53|78->53|79->54|80->55|80->55|81->56|81->56|86->61|86->61|86->61|86->61|87->62|87->62|87->62|87->62|90->65|90->65|90->65|90->65|90->65|91->66|92->67|92->67|93->68|93->68|95->70|95->70|95->70|96->71|97->72|97->72|98->73|98->73|98->73|98->73|98->73|98->73|98->73|99->74|100->75|100->75|101->76|102->77|102->77|103->78|103->78|105->80|105->80|106->81|107->82|107->82|107->82|107->82|107->82|108->83|109->84|109->84|110->85|110->85|110->85|110->85|110->85|111->86|112->87|112->87|113->88|113->88|115->90|118->93
                  -- GENERATED --
              */
          