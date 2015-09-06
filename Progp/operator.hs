ending	:: [a] -> [a]
ending(_:xs) = xs

beginning :: [a] -> a
beginning (x:_) = x

pred :: Int -> Int
pred 0 = 0
pred (n+1) = n
