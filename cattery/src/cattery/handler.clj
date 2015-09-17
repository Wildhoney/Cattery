(ns cattery.handler
  (:use compojure.core)
  (:require [clj-json.core :as json]))

(import 'java.security.MessageDigest
  'java.math.BigInteger)

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

;; parse-int :: string -> int
(defn parse-int [s]
  (when-let [d (re-find #"-?\d+" s)] (Integer. d)))

;; md5 :: -> string -> string
(defn md5 [s]
  (let [algorithm (MessageDigest/getInstance "MD5")
        size (* 2 (.getDigestLength algorithm))
        raw (.digest algorithm (.getBytes s))
        sig (.toString (BigInteger. 1 raw) 16)
        padding (apply str (repeat (- size (count sig)) "0"))]
    (str padding sig)))

;; mockUrl -> string
(def mockUrl "http://www.catgifpage.com/gifs/241.gif")

;; defaultCount -> int
(def defaultCount 10)

(defroutes handler

  (GET "/:id" [id]
    (json-response {"id" (md5 mockUrl) "url" mockUrl}))

  (GET "/random/:count" [count]
    (json-response ["count" (or (parse-int count) defaultCount)
                    "images" {"id" (md5 mockUrl) "image" mockUrl}]))

  (GET "/random" []
    (json-response {"id" (md5 mockUrl)
                     "image" mockUrl})))

(def app (-> handler wrap-json-params))