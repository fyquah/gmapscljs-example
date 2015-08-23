(defproject gmapscljs-example "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48" :classifier "aot"
                  :exclusion [org.clojure/data.json]]
                 [reagent "0.5.1-rc"]
                 [gmapscljs "0.0.2"]
                 [org.clojure/data.json "0.2.6" :classifier "aot"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]
            [lein-cljsbuild "1.0.6"]]
  :npm {:dependencies [[source-map-support "0.3.2"]]}
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target"
  :cljsbuild {
    :builds {
      :dev
      {:source-paths ["src"]
       :jar true
       :compiler {:output-to "out/main.js"
                  :output-dir "out/"   
                  :optimizations :whitespace
                  :pretty-print true
                  :source-map "out/main.js.map"}}
      :prod
      {:source-paths ["src"]
       :compiler {:output-to "release/out/main.js"
                  :output-dir "release/out"
                  :optimizations :advanced
                  :pretty-print false
                  :source-map "release/out/main.js.map"}}}})
