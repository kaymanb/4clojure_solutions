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

;; Reverse a sequence : 23
;; Works by conjoining in turn everything in the sequence. 
(fn [lst] (reduce conj () lst))

;; Palindrom Detector : 27
;; seq has to be there to support strings.
(fn [lst] (= (seq lst) (reverse (seq lst))))

;; Fibbonaci Sequence : 26
;; Use iterate to create a lazy sequence of pairs and just grab the first one.
(fn [n] (take n (map first (iterate (fn [[x y]] (seq [y (+ x y)])) [1 1]))))

;; Maximum Value : 38
(fn [& args] (reduce (fn [x y] (if (>= x y) x y)) args))

;; Get the Caps : 29
;; Notice you have to use 'apply' here because the sequence returned is lazy.
(fn [s] (apply str (filter (fn [x] (Character/isUpperCase x)) s)))

;; Duplicate a sentence : 32
;; This could be done cheaper (using conj) if we were only dealing with
;; vectors.
(fn [sqnc] (reduce (fn [x y] (concat x [y y])) () sqnc))

;; Implement Range : 34
;; First time using partial, really neat way of doing things I think.
(fn [bot top] (take (- top bot) (iterate (partial + 1) bot)))

;; Compress a Sequence : 30
;; Partition-by makes this very easy.
(fn [sqnc] (map first (partition-by identity sqnc)))

;; Factorial Fun : 42
;; This is waayyyy simpler than how I would have done it imperitavly
(fn [n] (reduce * (range 1 (+ n 1))))

;; Interleave sequences : 39
;; Can also be done (fn [s1 s2] (apply concat (map (fn [a b] (conj [] a b)) s1 s2))) 
(fn [s1 s2] (mapcat (fn [a b] (conj [] a b)) s1 s2)) 

;; Flatten a sequence : 28
;; Simple recursion solves this. 
(fn flat [sqnc] (if (coll? sqnc) (mapcat flat sqnc) (list sqnc)))

;; Replicate a sequence : 33
(fn [coll n] (reduce #(concat %1 (take n (repeat %2))) [] coll))

;; Interpose a sequence : 40
;; TODO: This could be much more efficient, butlast is a bad way of removing
;; trailing x.
(fn [x coll] (butlast (mapcat #(list %1 x) coll)))
