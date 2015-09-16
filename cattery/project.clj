(defproject cattery "0.1.0-SNAPSHOT"
  :description "Web-based API that delivers cats straight to your browser via JSON and YAML."
  :url "https://github.com/Wildhoney/Cattery"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [cheshire "5.5.0"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-json "0.4.0"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler cattery.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
