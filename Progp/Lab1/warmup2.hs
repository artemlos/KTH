module F1 where
import Data.Char

-- Abdallah Hassan & Artem Los.

-- A simple recursive fibonacci function.
{-
slowest way
fib :: Integer -> Integer
fib 0 = 0
fib 1 = 1
fib n = fib(n-1) + fib(n-2)
-}
-- the closed form of fib n is obviously faster then the conventional recurrence
-- faster way https://wiki.haskell.org/The_Fibonacci_sequence#Using_Binet.27s_formula
fib :: Integer -> Integer
fib n = round $ phi ^ n / sq5
	where
	    sq5 = sqrt 5 
	    phi = (1 + sq5) / 2

isConsonant :: Char -> Bool
isConsonant s = not (elem s ['a','e','i','o','u','y']

rovarsprak :: String -> String
rovarsprak "" = "" -- to stop the recursion
rovarsprak s = if isConsonant( head s) 
			   then [head s] ++ "o" ++[head s]++ rovarsprak( tail s)
			   else [head s] ++ rovarsprak(tail s)
-- Reverses the previous function.
karpsravor :: String -> String
karpsravor "" = ""
karpsravor (x:a)
  | not (elem x ['a','e','i','o','u','y']) = [x] ++ karpsravor (drop 3 (x:a))
  | otherwise = [x] ++ karpsravor (drop 1 (x:a))

-- This function takes in a string and returns the string of the N first elements that are alphabetic.
chopoff :: String -> String
chopoff "" = ""
chopoff (x:xs)
  | not (isAlpha x) = ""
  | otherwise = (x: chopoff xs)
-- This function takes in a string and returns an array of strings from the original string that are made of alphabetic characters. 
split :: String -> [String]
split "" = [""]
split s@(x:xs)
  | not (isAlpha x) = split (drop 1 s)
  | otherwise = (st:(split(drop (length st) s)))
  where st = chopoff(s)
-- Removes the empty string from an array of strings.
removeEmpty :: [String] -> [String]
removeEmpty s = [x | x <- s, x /= ""]
-- Takes in a string and computes the average length of words in it.
medellangd :: String -> Double
medellangd s = (fromIntegral (sum (map (length) c))) / (fromIntegral (length c))
  where c = removeEmpty (split s)

-- Takes in an array [a_0, a_1, a_2,...] and returns [a_0, a_2, a_4,...]
everytwo :: [a] -> [a]
everytwo [] = []
everytwo s = head s : everytwo (drop 2 s)
-- Shuffles an array by taking every two elements from the original array, and then every two elements from the remaining array etc.
skyffla :: [a] -> [a]
skyffla [] = []
skyffla s = everytwo s ++ skyffla (everytwo (drop 1 s))
