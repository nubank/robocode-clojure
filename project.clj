(defproject clobot "0.1.0-SNAPSHOT"
  :description "A simple leiningen project to build Robocode robots in Clojure"
  :url "https://github.com/JuntosFinanzas/robocode-clojure"
  :license {:name "EPL-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}

  ; If you change the clojure version, also change it in the makefile
  :dependencies [ [org.clojure/clojure "1.10.3"]
                  [net.sf.robocode/robocode.core "1.9.4.2"]]
  :aot [#"clobot.*"]
  :repl-options {:init-ns clobot})
