import scala.tools.nsc.MainGenericRunner

import bootstrap.liftweb.Boot

object LiftConsole {
  def main( args: Array[String] ) {
    new Boot().boot // Boot the project
    MainGenericRunner.main( args ) // Now run the MainGenericRunner to get your repl
    exit( 0 ) // After the repl exits, then exit the scala script
  }
}
