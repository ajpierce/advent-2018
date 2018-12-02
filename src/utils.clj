(ns utils
  (:require [clojure.string :as s]))

(defn get-input
  ([] (get-input "01"))
  ([day]
   (let [strings (-> (slurp (str "input/" day ".txt"))
                     (s/replace "+" "")
                     (s/split #"\s+"))]
     (map #(Integer/parseInt %) strings))))
