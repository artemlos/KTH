module F1 where

-- Vad ska de andra funktionernas typsignaturer vara?
{-
slowest way
fib :: Integer -> Integer
fib 0 = 0
fib 1 = 1
fib n = fib(n-1) + fib(n-2)
-}
-- faster way https://wiki.haskell.org/The_Fibonacci_sequence#Using_Binet.27s_formula
fib n = round $ phi ^ n / sq5
	where
	    sq5 = sqrt 5 
	    phi = (1 + sq5) / 2



rovarsprak s = s
karpsravor s = s
medellangd s = 1.0
skyffla s = s

