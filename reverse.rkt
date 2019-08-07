(define (reverse phrase)
  (if (empty? phrase)
      '()
      (cons (last phrase) (reverse (butlast phrase)))))