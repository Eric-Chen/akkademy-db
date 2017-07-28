name := """akkademy-db"""
organization := "com.akkademy-db"
version := "0.0.1-SNAPSHOT"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.projectlombok" % "lombok" % "1.16.8",
  // Uncomment to use Akka
  "com.typesafe.akka" % "akka-actor_2.12" % "2.5.3",
  "com.typesafe.akka" % "akka-remote_2.12" % "2.5.3",
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test",
  "com.typesafe.akka" %% "akka-testkit" % "2.5.3" % "test"
)

mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}
