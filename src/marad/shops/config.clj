(ns marad.shops.config
  (:require [clojure.edn :as edn]))

(def config-path (System/getProperty "CONFIG_PATH" "resources/config.edn"))
(def config (edn/read-string (slurp config-path)))
(defn get [key] (key config))