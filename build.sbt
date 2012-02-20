name := "Lift SBT Template"

version := "0.1"

scalaVersion := "2.9.1"

seq(webSettings: _*)

scanDirectories in Compile := Nil

resolvers ++= Seq(
  "Scala Tools Releases" at "http://scala-tools.org/repo-releases/",
  "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"
)

libraryDependencies ++= {
  val liftVersion = "2.4"
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default")
}

libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.0.v20120127" % "container; test",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "com.h2database" % "h2" % "1.2.138", // In-process database
  "ch.qos.logback" % "logback-classic" % "1.0.0" % "compile->default",
  "org.specs2" %% "specs2" % "1.8.1" % "test",
  "junit" % "junit" % "4.10" % "test->default",
  "org.mockito" % "mockito-all" % "1.9.0"
)

port in container.Configuration := 9081
