SHELL := /bin/bash

setup:
	@# Ensure that the project dependencies are present
	lein deps
	@# Create a new run script that puts Clojure on Robocode's Classpath
	@cp resources/cl-robocode.sh ~/robocode
	@CLOJURE_JAR="$$(realpath ~)/.m2/repository/org/clojure/clojure/1.10.3/clojure-1.10.3.jar";\
	sed -i '' 's#CLOJURE_JAR_PATH#'"$$CLOJURE_JAR"'#' ~/robocode/cl-robocode.sh
	@echo "Setup Complete."

clean:
	@# Clean the build and remove the robots
	lein clean
	@rm -rf ~/robocode/robots/clobot

build:
	lein compile

install: clean build
	@# Build the robots and then copy them into the /robots subdirectory
	@# where they can be picked up by Robocode
	@cp -r target/classes/clobot ~/robocode/robots
	@cp src/clobot/* ~/robocode/robots/clobot/
	@echo "Robot installation complete."
