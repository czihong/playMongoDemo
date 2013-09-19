import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "playMongoDemo"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
    		// Add your project dependencies here,
    		"com.google.code.morphia" % "morphia" % "0.99",
    		"org.mongodb" % "mongo-java-driver" % "2.7.3",
    		"com.google.code.morphia" % "morphia-logging-slf4j" % "0.99",
		javaCore,
		javaJdbc,
		javaEbean
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
    		// Add your own project settings here    
    		resolvers += "Maven repository" at "http://morphia.googlecode.com/svn/mavenrepo/",
    		resolvers += "MongoDb Java Driver Repository" at "http://repo1.maven.org/maven2/org/mongodb/mongo-java-driver/"
    )
}
