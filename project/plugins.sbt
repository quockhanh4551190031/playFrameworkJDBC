// Add resolver for Typesafe repository
resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

// Add the Play plugin only
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.9.0")

// Remove sbt-web plugin as it's included in the Play plugin
