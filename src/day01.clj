(ns day01
  (:require [utils :refer [get-input]]))

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
