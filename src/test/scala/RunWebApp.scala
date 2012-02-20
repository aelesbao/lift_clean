import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext

object RunWebApp extends Application {
  val scc = new SelectChannelConnector
  scc.setPort( 8080 )

  val server = new Server
  server.setConnectors( Array( scc ) )

  val context = new WebAppContext()
  context.setServer( server )
  context.setContextPath( "/" )
  context.setWar( "src/main/webapp" )
  context.setServer( server )

  try {
    println( ">>> STARTING EMBEDDED JETTY SERVER, PRESS ANY KEY TO STOP" )
    server.start()
    while ( System.in.available() == 0 ) {
      Thread.sleep( 5000 )
    }
    server.stop()
    server.join()
  } catch {
    case ex: Exception => {
      ex.printStackTrace()
      System.exit( 100 )
    }
  }
}
