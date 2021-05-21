(defproject clobot "0.1.0-SNAPSHOT"
  :description "A simple leiningen project to build Robocode robots in Clojure"
  :url "https://github.com/JuntosFinanzas/robocode-clojure"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [ [org.clojure/clojure "1.10.1"]
                  [net.sf.robocode/robocode.core "1.9.4.2"]]
  :aot [clobot.DemoRobot]
  :repl-options {:init-ns clobot.DemoRobot})
