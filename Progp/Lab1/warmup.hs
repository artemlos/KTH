module F1 where

import Data.Char

-- Vad ska de andra funktionernas typsignaturer vara?
{-
slowest way
fib :: Integer -> Integer
fib 0 = 0
fib 1 = 1
fib n = fib(n-1) + fib(n-2)
-}
-- the closed form of fib n is obviously faster then the conventional recurrence
-- faster way https://wiki.haskell.org/The_Fibonacci_sequence#Using_Binet.27s_formula
fib n = round $ phi ^ n / sq5
	where
	    sq5 = sqrt 5 
	    phi = (1 + sq5) / 2

rovarsprak :: String -> String
rovarsprak "" = "" -- to stop the recursion
rovarsprak s = if isConsonant( head s) 
			   then [head s] ++ "o" ++[head s]++ rovarsprak( tail s)
			   else [head s] ++ rovarsprak(tail s)

isConsonant :: Char -> Bool
isConsonant s = not('a' == s || 'e' == s || 'i' == s || 'o' == s || 'u' == s || 'y' == s)

karpsravor :: String -> String
karpsravor "" = ""
karpsravor s = if isConsonant( head s) 
			   then [head s]++karpsravor( drop 3 s)
			   else [head s] ++ karpsravor(tail s)

-- words/no of letters,
medellangd :: String -> Double
medellangd s = fromIntegral ( noOfLetters (s)) / (fromIntegral (length s -noOfLetters (s)) )

-- Calculates the number of letters in a string.
noOfLetters :: String -> Int
noOfLetters xs = length[x | x <- xs, isAlpha x]

skyffla s = s
