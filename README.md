# gmapscljs-example

A (very simple) example of using [gmapscljs](https://github.com/fyquah95/gmapscljs).

## A quick walkthrough

~~~clojure
; Create a atom of path
(def points (atom (make-points)))

; The main component is later rendered to the DOM using reagent/create-class
(defn main-component
  ([]
   [:div
    [:h1 "gmapscljs-example"]
    [:button
     {:on-click
      #(reset! points (make-points))}
     "Click me!"]
     ; in a hiccup like syntax, google-maps
     [google-maps {:style {:height 500}
                   :center (lat-lon 50 10)
                   :zoom 2}
      ; Declare components inside the google-maps
      ; component, you do not need to specify the map
      ; which is bind to, gmapscljs will do the magic!
      ; (There is a gotcha to this, refer gmapscljs'
      ; REAMDE)
      ; Draw a path between all the points!
      [polyline {:path @points
                 :key @points}]
      ; Have markers to indicate the points!
      ; Everything the points atom is mutated,
      ; this will re-draw / re-render itself
      (for [point @points]
        [marker {:key point
                 :position point}])]]))
~~~
