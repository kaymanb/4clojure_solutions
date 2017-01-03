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

;; Pack a Sequence : 31
(fn [coll] (partition-by identity coll))

;; Drop every nth : 41
;; First use of keep-indexed here, usefull.
(fn [coll n] (keep-indexed #(if (= 0 (mod (inc %1) n)) nil %2) coll))

;; Split a sequence : 49
(fn [n coll] (list (take n coll) (drop n coll)))

;; Advanced Destructuring : 51
;; You need to see the question for this solution to make sense.
[1 2 3 4 5]

;; Half Truth : 83
;; Not the use of boolean since nil != false
(fn [& args] (if (some true? args) (boolean (some false? args)) false))

;; Map Construction : 61
(fn [ks vs] (apply merge (map #(hash-map %1 %2) ks vs)))

;; Greatest Common Divisor : 66
;; Uses the fact that gcd(a, b) = gcd(a, (b mod a))
(fn [x y] ( if (zero? y) x (recur y (mod x y))))

;; Set Intersection : 81
(fn [a b] (set (filter #(contains? b %1) a)))

;; Comparisons : 166
(fn [f x y] (if (f x y) :lt (if (f y x) :gt :eq)))

;; Re-implement Iterate : 62
(fn [f i] (mapcat #(list ((apply comp (repeat %1 f)) i)) (range)))

;; Simple Clojures : 107
;; Simple exponentiation. Import 'clojure.contrib.math' to just use expt.
(fn [n] (fn [x] (reduce * (take n (repeat x)))))

;; Cartesian Product : 90
;; Order of a and b in this solution affects answer. Note that internal elemnts
;; are vectors not sets.
(fn [a b] (into #{} (mapcat (fn [x] (map #(vector %1 x) a)) b)))

;; Product Digits : 99
;; Not sure if using (comp int bigdec) is the best way to go from string to
;; integer or not, but it gets the job done.
(fn [x y] (let [prod (* x y)] (map (comp int bigdec str) (seq (str prod)))))

