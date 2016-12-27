;; 4Clojure Solutions
;; By order of difficulty
;; @author Kayman Brusse
;; http://www.4clojure.com/problems/${number}

;; ${name} : ${number}

;; Map Defaults : 156
(fn [default, ks] (zipmap ks (repeat default)))

;; Last Elements : 19
(fn [s] (first (reverse s)))

;; Penultimate Element : 20
(fn [s] (second (reverse s)))

;; Nth Element : 21
(fn [s, i] (first (nthnext s i)))

;; Count a Sequence : 22
(fn [lst] (reduce (fn [x y] (+ x 1)) 0 lst))

;; Sum it up : 24
(fn [lst] (reduce (fn [x, y] (+ x y)) lst))

;; Find the odd numbers
(fn [lst] (filter (fn [x] (= 1 (mod x 2))) lst)) 


