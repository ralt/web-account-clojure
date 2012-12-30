(ns my-website.models.account
  (:require [clojure.math.numeric-tower :as math]))

(defn calc-her-amount [my-salary her-salary total]
  (math/round (/ (/ (* her-salary
                       total)
                    my-salary)
                 (+ 1
                    (/ her-salary
                       my-salary)))))

(defn calc-my-amount [total her-amount]
  (math/round (- total her-amount)))

(defn- calc [my-salary her-salary total]
  (let [her-amount (calc-her-amount my-salary her-salary total)
        my-amount (calc-my-amount total her-amount)]
    {:her-amount her-amount :my-amount my-amount}))
