
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.37*/("""

"""),_display_(/*4.2*/main("Login")/*4.15*/ {_display_(Seq[Any](format.raw/*4.17*/("""
    """),format.raw/*5.5*/("""<h1>Login</h1>
    <form id="loginForm">
        """),_display_(/*7.10*/helper/*7.16*/.CSRF.formField),format.raw/*7.31*/("""
        """),format.raw/*8.9*/("""<div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
    </form>
    <a href=""""),_display_(/*18.15*/routes/*18.21*/.HomeController.register()),format.raw/*18.47*/("""">Register</a>

    <script>
        document.getElementById('loginForm').addEventListener('submit', async (e) => """),format.raw/*21.86*/("""{"""),format.raw/*21.87*/("""
            """),format.raw/*22.13*/("""e.preventDefault();
            const token = document.querySelector('input[name="csrfToken"]').value;
            const formData = """),format.raw/*24.30*/("""{"""),format.raw/*24.31*/("""
                """),format.raw/*25.17*/("""username: document.getElementById('username').value,
                password: document.getElementById('password').value
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/(""";

            try """),format.raw/*29.17*/("""{"""),format.raw/*29.18*/("""
                """),format.raw/*30.17*/("""const response = await fetch('/api/auth/login', """),format.raw/*30.65*/("""{"""),format.raw/*30.66*/("""
                    """),format.raw/*31.21*/("""method: 'POST',
                    headers: """),format.raw/*32.30*/("""{"""),format.raw/*32.31*/("""
                        """),format.raw/*33.25*/("""'Content-Type': 'application/json',
                        'Csrf-Token': token
                    """),format.raw/*35.21*/("""}"""),format.raw/*35.22*/(""",
                    body: JSON.stringify(formData)
                """),format.raw/*37.17*/("""}"""),format.raw/*37.18*/(""");

                const result = await response.json();

                if (response.ok) """),format.raw/*41.34*/("""{"""),format.raw/*41.35*/("""
                    """),format.raw/*42.21*/("""window.location.href = '/';
                """),format.raw/*43.17*/("""}"""),format.raw/*43.18*/(""" """),format.raw/*43.19*/("""else """),format.raw/*43.24*/("""{"""),format.raw/*43.25*/("""
                    """),format.raw/*44.21*/("""alert(result.message || 'Login failed');
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/("""
            """),format.raw/*46.13*/("""}"""),format.raw/*46.14*/(""" """),format.raw/*46.15*/("""catch (error) """),format.raw/*46.29*/("""{"""),format.raw/*46.30*/("""
                """),format.raw/*47.17*/("""console.error('Error:', error);
            """),format.raw/*48.13*/("""}"""),format.raw/*48.14*/("""
        """),format.raw/*49.9*/("""}"""),format.raw/*49.10*/(""");
    </script>
""")))}),format.raw/*51.2*/(""" """))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/login.scala.html
                  HASH: 145357e3fbb817afe6b543dd27f5f0817ea737f2
                  MATRIX: 432->1|777->37|907->72|937->77|958->90|997->92|1029->98|1107->150|1121->156|1156->171|1192->181|1600->562|1615->568|1662->594|1807->711|1836->712|1878->726|2040->860|2069->861|2115->879|2278->1014|2307->1015|2356->1036|2385->1037|2431->1055|2507->1103|2536->1104|2586->1126|2660->1172|2689->1173|2743->1199|2873->1301|2902->1302|3001->1373|3030->1374|3154->1470|3183->1471|3233->1493|3306->1538|3335->1539|3364->1540|3397->1545|3426->1546|3476->1568|3562->1626|3591->1627|3633->1641|3662->1642|3691->1643|3733->1657|3762->1658|3808->1676|3881->1721|3910->1722|3947->1732|3976->1733|4026->1753
                  LINES: 17->1|22->2|27->2|29->4|29->4|29->4|30->5|32->7|32->7|32->7|33->8|43->18|43->18|43->18|46->21|46->21|47->22|49->24|49->24|50->25|52->27|52->27|54->29|54->29|55->30|55->30|55->30|56->31|57->32|57->32|58->33|60->35|60->35|62->37|62->37|66->41|66->41|67->42|68->43|68->43|68->43|68->43|68->43|69->44|70->45|70->45|71->46|71->46|71->46|71->46|71->46|72->47|73->48|73->48|74->49|74->49|76->51
                  -- GENERATED --
              */
          