package code
package snippet

import java.util.Date
import code.lib.DependencyFactory
import net.liftweb.util.Helpers.strToCssBindPromoter
import net.liftweb.common.Box

class HelloWorld {
  lazy val date: Box[Date] = DependencyFactory.inject[Date]

  def howdy = "#time *" #> date.map( _.toString )
}