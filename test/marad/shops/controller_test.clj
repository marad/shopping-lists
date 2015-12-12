(ns marad.shops.controller-test
  (:require [clojure.test :refer :all]
            [ring.mock.request]
            [marad.shops.controller :refer :all]))

(deftest test-validators
  (testing "proper item"
    (let [item {:date 1
                :shop "shop-name"
                :ware "ware-name"
                :amount 2
                :price 1.99}
          result (validate-item item)]
      (is (= nil (first result)))
      ))
  (testing "invalid item"
    (let [item {:date 1
                :shop "shop-name"
                :ware "ware-name"
                :amount "invalid-entry"
                :price 1.99}
          result (validate-item item)]
      (is (= (:amount (first result)) ["amount must be a number"]))
      ))
  )
