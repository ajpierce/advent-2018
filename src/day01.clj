(ns day01
  (:require [utils :refer [get-input parse-as-numbers]]))

(defn part1 []
  (->> (get-input) parse-as-numbers (apply +)))

(defn part2 []
  (let [input-forever (cycle (-> (get-input) parse-as-numbers))]
    (loop [f (first input-forever)
           seen #{(first input-forever)}
           inputs (rest input-forever)]
      (let [delta (first inputs)
            i (+ f delta)]
        (if (contains? seen i)
          i
          (recur i (conj seen i) (rest inputs)))))))

(defn -main []
  (let [a1 (time (part1))
        a2 (time (part2))]
    (println "Part 1 answer is:" a1)
    (println "Part 2 answer is:" a2)))
