(ns cattery.handler
  (:use compojure.core
        instagram.oauth
        instagram.callbacks
        instagram.callbacks.handlers
        instagram.api.endpoint)
  (:require [clj-json.core :as json])
  (:import
    (instagram.callbacks.protocols SyncSingleCallback)))

(def ^:dynamic *creds* (make-oauth-creds *client-id*
                         *client-secret*
                         *redirect-uri*))

(def groups ["cats_of_instagram", "catsofinstagram"])

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes handler

  (GET "/random/:count" [count]
    (json-response ["count" (or (parse-int count) defaultCount)
                    "images" {"id" (md5 mockUrl) "image" mockUrl}]))

(def app (-> handler wrap-json-params)))
