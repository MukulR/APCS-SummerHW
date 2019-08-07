(define (factorial num)
  (if (> num 0)
     (* num (factorial (- num 1)))
     1))
  
      