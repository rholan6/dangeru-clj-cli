(ns dangeru-test.core
  (:gen-class)
  (:require [dangeru-clj.dangeru :as dangeru]
            [clojure.string :as string]))

(defn print-index [threads]
  (when (not= (first threads) nil)
    (println (:title (first threads)) " (#" (:id (first threads)) ")\n")
    (recur (next threads))))

(defn get-threads [index-map]
  (:threads index-map))

(defn index [& args]
  (def arglist (first args))
  (if (= (count arglist) 2)
    (print-index (get-threads (dangeru/index (first arglist) (last arglist))))
    (println "Wrong number of arguments for index:" (count arglist) " (should be 2)")))

(defn print-replies [replies]
  (when (not= (first replies) nil)
    (println "| " (:post (first replies)) "\n")
    (recur (next replies))))

(defn print-thread [thread-map]
  (def header (first (:meta thread-map)))
  (println (:title header) " (#" (:id header) ")\n\n")
  (print-replies (:replies thread-map)))

(defn thread [& args]
  (def arglist (first args))
  (if (= (count arglist) 3)
    (print-thread (dangeru/thread (first arglist) (second arglist) (last arglist)))
    (println "Wrong number of arguments for thread:" (count arglist) " (should be 3)")))

(defn -main [& args]
  (def one (first args))
  (if (string/ends-with? one "index")
    (println (index (rest args)))
    (if (string/ends-with? one "thread")
      (println (thread (rest args)))
      (println one " is not a valid command, use index or thread"))))

;;(defn -main [& args]
;;  (println "Fuck this gay language"))
