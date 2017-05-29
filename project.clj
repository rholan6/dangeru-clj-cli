(defproject dangeru-clj-cli "0.1.0-SNAPSHOT"
  :description "CLI board/thread indexer for Danger/u/ using dangeru-clj"
  :url "http://github.com/rholan6/dangeru-clj-cli"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [dangeru-clj "1.0.1"]]
  :main ^:skip-aot dangeru-test.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
