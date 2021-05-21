# Robocode in Clojure

A Clojure project to build [Robocode](https://robocode.sourceforge.io/) robots.

## Prerequisites

You must have a working installation of Clojure, Leiningen, and Robocode to for
this project to properly work.  Setup steps for these can be found at their
respective sites:

* [Getting Started with Clojure](https://clojure.org/guides/getting_started)
* [Install Leiningen](https://leiningen.org/#install)
* [Install Robocode](https://robocode.sourceforge.io/)

Note: This project assumes that Robocode is installed into its default
location which is `~/robocode`

## Setup & Test

This project uses a makefile to simplify the installation and setup of
your Robot.  Assuming that Robocode is installed in the default location of
`~/robocode`, you can run:

```
make setup
```

This will install a customer shell script called `cl-robocode.sh` into your
`~/robocode` directory.  To run Robocode with a Clojure Robot, you must run
Robocode from the command line using this script.

Then run:

```
make install
```

This should compile the `DemoRobot` and install it into your `~/robocode/robots/`
directory.  You can then verify everything is working by running Robocode.
From the `~/robocode/` directory, run:

```
./cl-robocode.sh
```

Robocode should start, and when you use the UI to start a new battle, the
`clobot.DemoRobot` should be selectable.

## Your Own Robot

You can make your own Robot by creating a new `.clj` file under the
`src/clobot/` directory.  Start by copying the `DemoRobot.clj` into
a new file with the name of the Robot you want to create.

Then, you can write your own implementations of `run` and `onScannedRobot` plus
any other functions you want to implement as a part of the [Robocode API](https://robocode.sourceforge.io/docs/robocode/)

## License

Copyright © 2021 Juntos Inc.

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
