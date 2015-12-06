(ns marad.shops.db
  (:require [clojure.java.jdbc :as sql]))

(def db-spec
  {:classname "com.mysql.jdbc.Driver"
   :subprotocol "mysql"
   :subname "//172.17.0.2:3306/shoppinglist"
   :user "shoppinglist"
   :password "shoppinglist"})

(defn add-item [item]
  "Inserts item into the database and returns it's id"
  (sql/insert! db-spec :items item))

(defn remove-item [id]
  "Removes item from the database"
  (sql/delete! db-spec :items ["id = ?" id]))

(defn list-items []
  "Lists all items"
  (sql/query db-spec "select id, date, shop, ware, amount, price from items"))

(defn list-shops []
  "Lists all shops already used in the app"
  (map :shop (sql/query db-spec "select distinct shop from items")))

(defn list-wares []
  "Lists all wares already used in the app"
  (map :ware (sql/query db-spec "select distinct ware from items")))
