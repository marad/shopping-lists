(ns marad.shops.controller
  (:require [marad.shops.db :as db]
            [ring.util.response :refer [response, status]]
            [bouncer.core :as b]
            [bouncer.validators :refer [string, required, number, positive, integer]]
            ))

(defn validate-item
  [item]
  (b/validate item
              :date [required integer positive]
              :shop [required string]
              :ware [required string]
              :amount [required number positive]
              :price [required number positive]
              ))

(def example-item {:date 2
                   :shop "Intermarche"
                   :ware 21
                   :amount 12.4
                   :price 23.2})
(let [[errors it] (validate-item example-item)]
  (println errors)
  (println it))

(defn add-item [item]
  "Adds item to database"
  (response "ok"))
  ;(if (item-valid? item)
  ;  (response (db/add-item item))
  ;  (status (response {:error "Invalid item"}) 400)
  ;  ))
