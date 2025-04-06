
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>"""),_display_(/*6.17*/title),format.raw/*6.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(/*7.54*/controllers/*7.65*/.routes.Assets.versioned("stylesheets/bootstrap/bootstrap.css")),format.raw/*7.128*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.59*/controllers/*8.70*/.routes.Assets.versioned("images/favicon.png")),format.raw/*8.116*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*9.54*/controllers/*9.65*/.routes.Assets.versioned("stylesheets/main.css")),format.raw/*9.113*/("""">
        <script src=""""),_display_(/*10.23*/controllers/*10.34*/.routes.Assets.versioned("javascripts/bootstrap/bootstrap.bundle.min.js")),format.raw/*10.107*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(/*13.10*/content),format.raw/*13.17*/("""
    """),format.raw/*14.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: f0442473a0939ac3dc60b51f81e17cf1e58f9ee0
                  MATRIX: 733->1|858->31|888->35|977->98|1002->103|1091->166|1110->177|1194->240|1282->302|1301->313|1368->359|1451->416|1470->427|1539->475|1592->501|1612->512|1707->585|1804->655|1832->662|1865->668
                  LINES: 21->1|26->1|28->3|31->6|31->6|32->7|32->7|32->7|33->8|33->8|33->8|34->9|34->9|34->9|35->10|35->10|35->10|38->13|38->13|39->14
                  -- GENERATED --
              */
          