(ns marad.shops.db
  (:require [clojure.java.jdbc :as sql]
            [marad.shops.config :as config]))

(def db-spec (config/get :db-spec))

(defn add-item [item]
  "Inserts item into the database and returns it's id"
  (sql/insert! db-spec :items item))

(defn expand-receipt [receipt]
  "Takes receipt and returns list of items"
  (map #(assoc % :date (:date receipt)
                 :shop (:shop receipt))
       (:items receipt)))

;(defn add-receipt [receipt]
;  "Inserts multiple items to the database"
;  (sql/with-db-transaction [conn db-spec]
;    (map add-item (extract-items receipt))))

(defn add-receipt [receipt]
  "Inserts multiple items to the database"
  (apply sql/insert! db-spec :items (expand-receipt receipt)))

;(let [receipt {:date "2015-12-12"
;               :shop "Intermarche"
;               :items [{:ware "Mleko" :amount 2 :price 1.22}
;                       {:ware "Ser" :amount 1 :price 2}]}]
;  (add-receipt receipt))


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
