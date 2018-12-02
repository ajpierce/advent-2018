(ns day02
  (:require [clojure.data :refer [diff]]
            [clojure.string :as s]
            [utils :refer [get-input]]))

(defn count-letters [row]
  (-> row seq frequencies))

(defn occurrences [counts]
  (into #{} (vals counts)))

(defn part1 []
  (loop [remaining (-> (get-input "02") (s/split #"\s+"))
         twos 0
         threes 0]
    (if (empty? remaining)
      (* twos threes)
      (let [occs (-> (first remaining) count-letters occurrences)]
        (recur (rest remaining)
               (if (contains? occs 2) (inc twos) twos)
               (if (contains? occs 3) (inc threes) threes))))))

(defn common-letters [a b]
  (let [[_ _ common] (diff (seq a) (seq b))]
    (->> common
         (filter some?)
         (apply str))))

(defn found? [current remaining]
  (loop [remaining remaining]
    (if (empty? remaining)
      nil
      (let [target (first remaining)
            common (common-letters current target)]
        (if (= (-> current count dec) (count common))
          common
          (recur (rest remaining)))))))

(defn part2 []
  (let [rows (-> (get-input "02") (s/split #"\s+") sort)]
    (loop [current (first rows)
           remaining (rest rows)]
      (let [found (found? current remaining)]
        (if (= nil found)
          (recur (first remaining) (rest remaining))
          found)))))

(defn -main []
  (let [a1 (time (part1))
        a2 (time (part2))]
    (println "Part 1 answer is:" a1)
    (println "Part 2 answer is:" a2)))
