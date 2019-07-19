// Note if this file is named module-info.java_ (with an underscore at the end),
// it disables multi-module mode in Java 9 or later.  Remove the underscore to
// enable multi-module mode. But doing so requires a change to the pom.xml file.
// You'll need to uncomment the maven-compiler-plugin section corresponding with
// "Java 9 or later module mode" and comment out the existing maven-compiler-plugin
// setting.

module sample_project {
  requires manifold.all;
  requires java.scripting;  // using Json manifold: for javax.script.Bindings
  requires java.desktop;    // using Image manifold: for javax.swing.ImageIcon
  requires jdk.unsupported; // for java 11+

  // Register the sample Date proxy factory service implementation
  // (note the META-INF/services registration is still necessary for Java 8 and Java 9+ unnamed-module)
  provides manifold.ext.api.IProxyFactory
    with sample_project.extensions.java.time.chrono.ChronoLocalDateTime.Date_To_ChronoLocalDateTime;
}