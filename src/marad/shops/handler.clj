(ns marad.shops.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [marad.shops.db :as db]
            [marad.shops.controller :as ctrl]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-response, wrap-json-body]]
            [ring.util.response :refer [response]]
            ))

(defroutes app-routes
           (GET "/" [] "Hello World")
           (GET "/shops" [] (response {:shops (db/list-shops)}))
           (GET "/wares" [] (response {:wares (db/list-wares)}))
           (GET "/items" [] (response {:items (db/list-items)}))
           (POST "/items" {body :body} (ctrl/add-item body))
           (POST "/receipt" {body :body} (ctrl/add-receipt body))
           (route/not-found "Not Found"))

(def app
  (-> app-routes
      (wrap-json-body {:keywords? true :bigdecimals? true})
      (wrap-json-response)
      (wrap-defaults api-defaults)
      ))
