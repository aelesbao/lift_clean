package bootstrap.liftweb

import net.liftweb.common.Full
import net.liftweb.http.LiftRulesMocker.toLiftRules
import net.liftweb.http.LiftRules
import net.liftweb.sitemap.Loc.LinkText.strToLinkText
import net.liftweb.sitemap.LocPath.stringToLocPath
import net.liftweb.sitemap.Loc.Link
import net.liftweb.sitemap.Loc
import net.liftweb.sitemap.Menu
import net.liftweb.sitemap.SiteMap

class Boot {
  def boot {
    // where to search snippet
    LiftRules.addToPackages( "code" )

    // Build SiteMap
    val entries = List(
      Menu.i( "Home" ) / "index", // the simple way to declare a menu

      // more complex because this menu allows anything in the
      // /static path to be visible
      Menu( Loc( "Static", Link( List( "static" ), true, "/static/index" ),
        "Static Content" ) ) )

    // Force the request to be UTF-8
    LiftRules.early.append( _.setCharacterEncoding( "UTF-8" ) )

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
    LiftRules.setSiteMap( SiteMap( entries: _* ) )

    // Use jQuery 1.4
    LiftRules.jsArtifacts = net.liftweb.http.js.jquery.JQuery14Artifacts

    LiftRules.ajaxStart = Full( () => LiftRules.jsArtifacts.show( "ajax-loader" ).cmd )
    LiftRules.ajaxEnd = Full( () => LiftRules.jsArtifacts.hide( "ajax-loader" ).cmd )
  }
}