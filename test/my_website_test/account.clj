(ns my-website-test.account
  (:use clojure.test)
  (:require [my-website.models.account :as acc]))

(deftest account
  (is (= 711 (:my-amount (acc/calc(1600 1100 1200))))))