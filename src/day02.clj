(ns day02
  (:require [clojure.string :as s]
            [utils :refer [get-input]]))

(defn count-letters [row]
  (-> row seq frequencies))

(defn occurrences [counts]
  (into #{} (vals counts)))

(defn two? [occs]
  (contains? occs 2))

(defn three? [occs]
  (contains? occs 3))

(defn part1 []
  (loop [remaining (-> (get-input "02") (s/split #"\s+"))
         twos 0
         threes 0]
    (if (empty? remaining)
      (* twos threes)
      (let [occs (-> (first remaining) count-letters occurrences)]
        (recur (rest remaining)
               (if (two? occs) (inc twos) twos)
               (if (three? occs) (inc threes) threes))))))

(defn part2 [])

(defn -main []
  (let [a1 (time (part1))
        a2 (time (part2))]
    (println "Part 1 answer is:" a1)
    (println "Part 2 answer is:" a2)))