(ns cattery.handler
  (:use compojure.core)
  (:use ring.middleware.json-params)
  (:require [clj-json.core :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

;; capitalise-all :: string -> string
;(defn capitalise-all [name]
;  (clojure.string/join
;    (map clojure.string/capitalize
;      (clojure.string/split (str name) #"\b"))))
;
;;; thousand-times :: int -> int
;(def thousand-times
;  (partial * 1000))
;
;;; random-coin-value :: _ -> int
;(def random-coin-value
;  (partial rand-int 10))

(defroutes handler
;  (GET "/:name" [name]
;    (let [coins (thousand-times (random-coin-value))]
;      (json-response {"name" (capitalise-all name),
;                      "coins_available" coins,
;                      "is_bankrupt" (zero? coins)})))

  (GET "/random/:count" [count]
    (json-response [{"url" "http://www.catgifpage.com/gifs/241.gif"}]))

  (GET "/random" []
    (json-response {"url" "http://www.catgifpage.com/gifs/241.gif"})))

(def app
  (-> handler
    wrap-json-params))