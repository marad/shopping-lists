(ns marad.shops.controller
  (:require [marad.shops.db :as db]
            [ring.util.response :refer [response, status]]
            [bouncer.core :as b]
            [bouncer.validators :refer [string, required, number, positive, integer, datetime, every]]
            [clj-time.format :as f]
            ))

(defn validate-item [item]
  (b/validate item
              :date [required string [datetime (:date f/formatters)]]
              :shop [required string]
              :ware [required string]
              :amount [required number positive]
              :price [required number positive]
              ))

(defn add-item [item]
  "Adds item to database"
  (let [[errors validated-item] (validate-item item)]
    (if errors
      (response errors)
      (response (db/add-item item)))))

(defn validate-receipt-item [item]
  (b/validate item
              :ware [required string]
              :amount [required number positive]
              :price [required number positive]))

(defn validate-receipt [receipt]
  (b/validate receipt
              :date [required string [datetime (:date f/formatters)]]
              :shop [required string]
              :items [required [every validate-receipt-item]]
              ))

(defn add-receipt [receipt]
  "Adds multiple items to database"
  (let [[errors validated-receipt] (validate-receipt receipt)]
    (if errors
      (response errors)
      (response (db/add-receipt receipt)))
    ))
