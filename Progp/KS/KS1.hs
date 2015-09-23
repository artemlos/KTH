data HElem = IE Int
           | FE Float
           | RE Rational
           deriving (Show, Eq)

tal = [IE 17, FE 1.0, RE 1.2, IE 23]


baraheltal :: [HElem] -> [Int]
baraheltal [] = []
baraheltal ((IE x):xs) = x:baraheltal(xs)
baraheltal (_:xs) = baraheltal (xs)