Lift Clean
==========

This is a clean and updated configuration for the Lift Blank template found on
[Liftweb](http://liftweb.net/) site.

This project uses:

* SBT 0.11.2
* Jetty 8.1.0
* Specs2 1.8.1

Running
-------

At the project root, execute `./sbt` to open the SBT shell. You'll need to wait a few
minutes while it downloads all the dependencies... :O zzzz

When it's done, type `~container:start`, access `http://localhost:9081/` and enjoy ;)

How to setup Eclipse
--------------------

First, get the [Scala IDE plugin](http://scala-ide.org/). To fine tune your settings,
follow the instructions [here](http://scala-ide.org/docs/user/advancedsetup.html).

Then, run `./sbt eclipse` to create the `.project` and `.classpath` files. Now on Eclipse
you'll just need to go to `File -> Import...` and choose *Existing projects into workspace*.

Too easy! :)

See also
--------

* [Simple Build Tool](https://github.com/harrah/xsbt)
* [sbteclipse](https://github.com/typesafehub/sbteclipse): the SBT plugin used to generate the project files
* [Liftweb Wiki > Using SBT](http://www.assembla.com/spaces/liftweb/wiki/Using_SBT): instructions on how to setup Lift with SBT 0.10.x
