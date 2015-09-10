--lowers :: String -> Int
--lowers xs = length[x | x <- xs, isLower x]

count 	:: Char -> String -> Int
count x xs = length [x' | x' <- xs, x ==x']