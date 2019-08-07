(define (safe-divider n)
  (lambda (x)
    (if (equal? x 0)
        'cow
        (/ n x))))


(define divide-by-12 (safe-divider 12))



;(define (divide-by-12 x)
;  (if (equal? x 0)
;      'cow
;      (/ 12 x)))
 