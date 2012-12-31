(ns my-website.views.welcome
  (:require [my-website.views.common :as common])
  (:use [noir.core :only [defpage]])
  (:require [noir.core :refer [render]])
  (:require [my-website.models.account :as acc])
  (:require [hiccup.form :as h]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to my-website"]))

(defpage "/" []
  (common/layout
   (h/form-to [:post "/"]
            (h/label "my-salary" "My salary")
            (h/text-field "my-salary")
            [:br]
            (h/label "her-salary" "Her salary")
            (h/text-field "her-salary")
            [:br]
            (h/label "total" "Total")
            (h/text-field "total")
            [:br]
            (h/submit-button "Calculate"))))

(defpage [:post "/"] {:as data}
  (let [[my-salary her-salary total] data]
    (render "/result" (acc/calc(my-salary
                                her-salary
                                total)))))

(defpage "/result" {:as data}
  (common/layout
   [:p data]))