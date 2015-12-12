(defproject shopping-lists "0.1.0-SNAPSHOT"
  :description "Tool to store and analyze shopping lists"
  :url "http://radoszewski.pl/shipping-lists"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.4.0"]
                 [bouncer "0.3.3"]
                 [ring/ring-defaults "0.1.5"]
                 [ring/ring-json "0.4.0"]
                 [org.clojure/java.jdbc "0.4.2"]
                 [org.clojure/data.json "0.2.6"]
                 [mysql/mysql-connector-java "5.1.37"]
                 ]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler marad.shops.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}
   :repl {:plugins [[cider/cider-nrepl "0.11.0-SNAPSHOT"]]
          :dependencies [[org.clojure/tools.nrepl "0.2.12"]]}
   })
