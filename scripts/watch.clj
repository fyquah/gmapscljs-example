(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'gmapscljs-example.core
   :output-to "out/gmapscljs_example.js"
   :output-dir "out"})
