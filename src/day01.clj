(ns day01
  (:require [clojure.string :as s]))

(defn get-input
  ([] (get-input "input/01.txt"))
  ([path]
   (let [strings (-> (slurp path)
                     (s/replace "+" "")
                     (s/split #"\s+"))]
     (map #(Integer/parseInt %) strings))))

(defn part1 []
  (->> (get-input) (apply +)))

(defn part2 []
  (let [input-forever (cycle (get-input))]
    (loop [f (first input-forever)
           seen #{(first input-forever)}
           inputs (rest input-forever)]
      (let [delta (first inputs)
            i (+ f delta)]
        (if (contains? seen i)
          i
          (recur i (conj seen i) (rest inputs)))))))

(defn -main []
  (println "Part 1 answer is:" (part1))
  (println "Part 2 answer is:" (part2)))
