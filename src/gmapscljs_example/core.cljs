(ns gmapscljs-example.core
  (:require [reagent.core :as reagent :refer [atom]]
            [clojure.browser.repl :as repl]
            [gmapscljs.core :refer [google-maps polyline marker]]
            [gmapscljs.utils :as map.utils
                             :refer [lat-lon]]))

(defn make-points
  "Make 5 random points" 
  ([]
  (repeatedly 5 map.utils/random-point)))

(def points (atom (make-points)))

(defn main-component
  ([]
   [:div
    [:h1 "gmapscljs-example"]
    [:button
     {:on-click
      #(reset! points (make-points))}
     "Click me!"]
     [google-maps {:style {:height 500}
                   :center (lat-lon 50 10)
                   :zoom 2}
      ; Draw a path between all the points!
      [polyline {:path @points
                 :key @points}]
      ; Have markers to indicate the points!
      (for [point @points]
        [marker {:key point
                 :position point}])]]))

; set event listener
(set! (.-onload js/window)
      (fn []
        (reagent/render-component
          [main-component]
          (js/document.getElementById "app"))))
