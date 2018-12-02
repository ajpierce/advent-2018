(ns utils
  (:require [clojure.string :as s]))

(defn get-input
  ([] (get-input "01"))
  ([day]
   (slurp (str "input/" day ".txt"))))

(defn parse-as-numbers [input]
  (let [strings (-> input
                    (s/replace "+" "")
                    (s/split #"\s+"))]
    (map #(Integer/parseInt %) strings)))
