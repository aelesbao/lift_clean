package code
package snippet

import scala.annotation.serializable

import org.specs2.mutable.SpecificationWithJUnit

import code.lib.DependencyFactory
import net.liftweb.common.Empty
import net.liftweb.http.LiftSession
import net.liftweb.util.Helpers.now
import net.liftweb.util.Helpers.randomString

object HelloWorldTestSpecs extends SpecificationWithJUnit {
  val session = new LiftSession( "", randomString( 20 ), Empty )

  "HelloWorld Snippet" should {
    "Put the time in the node" in {
      val stableTime = now
      DependencyFactory.time.doWith( stableTime ) {
        Thread.sleep( 1000 ) // make sure the time changes

        val hello = new HelloWorld
        val str = hello.howdy( <span>Welcome to your Lift app at <span id="time">Time goes here</span></span> ).toString
        str.indexOf( stableTime.toString ) must be >= 0
      }
    }
  }
}
