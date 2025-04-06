
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

object register extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.37*/("""

"""),_display_(/*4.2*/main("Register")/*4.18*/ {_display_(Seq[Any](format.raw/*4.20*/("""
    """),format.raw/*5.5*/("""<h1>Register</h1>
    <form id="registerForm">
        """),_display_(/*7.10*/helper/*7.16*/.CSRF.formField),format.raw/*7.31*/("""
        """),format.raw/*8.9*/("""<div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Register</button>
    </form>
    <a href=""""),_display_(/*18.15*/routes/*18.21*/.HomeController.index()),format.raw/*18.44*/("""">Back to login</a>

    <script>
        document.getElementById('registerForm').addEventListener('submit', async (e) => """),format.raw/*21.89*/("""{"""),format.raw/*21.90*/("""
            """),format.raw/*22.13*/("""e.preventDefault();
            const token = document.querySelector('input[name="csrfToken"]').value;
            const formData = """),format.raw/*24.30*/("""{"""),format.raw/*24.31*/("""
                """),format.raw/*25.17*/("""username: document.getElementById('username').value,
                password: document.getElementById('password').value
            """),format.raw/*27.13*/("""}"""),format.raw/*27.14*/(""";

            try """),format.raw/*29.17*/("""{"""),format.raw/*29.18*/("""
                """),format.raw/*30.17*/("""const response = await fetch('/api/auth/register', """),format.raw/*30.68*/("""{"""),format.raw/*30.69*/("""
                    """),format.raw/*31.21*/("""method: 'POST',
                    headers: """),format.raw/*32.30*/("""{"""),format.raw/*32.31*/("""
                        """),format.raw/*33.25*/("""'Content-Type': 'application/json',
                        'Csrf-Token': token
                    """),format.raw/*35.21*/("""}"""),format.raw/*35.22*/(""",
                    body: JSON.stringify(formData)
                """),format.raw/*37.17*/("""}"""),format.raw/*37.18*/(""");

                const result = await response.json();

                if (response.ok) """),format.raw/*41.34*/("""{"""),format.raw/*41.35*/("""
                    """),format.raw/*42.21*/("""window.location.href = '/login';
                """),format.raw/*43.17*/("""}"""),format.raw/*43.18*/(""" """),format.raw/*43.19*/("""else """),format.raw/*43.24*/("""{"""),format.raw/*43.25*/("""
                    """),format.raw/*44.21*/("""// Display the error message from the server
                    alert(result.message || 'Registration failed');
                """),format.raw/*46.17*/("""}"""),format.raw/*46.18*/("""
            """),format.raw/*47.13*/("""}"""),format.raw/*47.14*/(""" """),format.raw/*47.15*/("""catch (error) """),format.raw/*47.29*/("""{"""),format.raw/*47.30*/("""
                """),format.raw/*48.17*/("""console.error('Error:', error);
            """),format.raw/*49.13*/("""}"""),format.raw/*49.14*/("""
        """),format.raw/*50.9*/("""}"""),format.raw/*50.10*/(""");
    </script>
""")))}),format.raw/*52.2*/(""" """))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/register.scala.html
                  HASH: 29ff999d97ef7fa838679d0b30e2e632d4b99e1c
                  MATRIX: 432->1|780->37|910->72|940->77|964->93|1003->95|1035->101|1119->159|1133->165|1168->180|1204->190|1615->574|1630->580|1674->603|1827->728|1856->729|1898->743|2060->877|2089->878|2135->896|2298->1031|2327->1032|2376->1053|2405->1054|2451->1072|2530->1123|2559->1124|2609->1146|2683->1192|2712->1193|2766->1219|2896->1321|2925->1322|3024->1393|3053->1394|3177->1490|3206->1491|3256->1513|3334->1563|3363->1564|3392->1565|3425->1570|3454->1571|3504->1593|3663->1724|3692->1725|3734->1739|3763->1740|3792->1741|3834->1755|3863->1756|3909->1774|3982->1819|4011->1820|4048->1830|4077->1831|4127->1851
                  LINES: 17->1|22->2|27->2|29->4|29->4|29->4|30->5|32->7|32->7|32->7|33->8|43->18|43->18|43->18|46->21|46->21|47->22|49->24|49->24|50->25|52->27|52->27|54->29|54->29|55->30|55->30|55->30|56->31|57->32|57->32|58->33|60->35|60->35|62->37|62->37|66->41|66->41|67->42|68->43|68->43|68->43|68->43|68->43|69->44|71->46|71->46|72->47|72->47|72->47|72->47|72->47|73->48|74->49|74->49|75->50|75->50|77->52
                  -- GENERATED --
              */
          