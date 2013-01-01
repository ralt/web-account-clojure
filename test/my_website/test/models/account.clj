(ns my-website.test.models.account
  (:use clojure.test)
  (:require [my-website.models.account :as acc]))

(deftest account
  (let [actual (acc/calc 1600 1100 1200)]
    (is (= 711 (:my-amount actual)))))