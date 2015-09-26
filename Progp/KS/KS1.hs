data HElem = IE Int
           | FE Float
           | RE Rational
           deriving (Show, Eq)

tal = [IE 17, FE 1.0, RE 1.2, IE 23]


baraheltal :: [HElem] -> [Int]
baraheltal [] = []
baraheltal ((IE x):xs) = x:baraheltal(xs)
baraheltal (_:xs) = baraheltal (xs)

-- An infinite long list of true and false.
truefalse :: [Bool]
truefalse = True : False : truefalse

vartannat :: [a] -> [a]
vartannat [] = []
vartannat [x] = [x]
vartannat (x1:x2:xs) = x1 :(vartannat xs)

-- Returns a list where both f1 and f2 are true.
-- f1 and f2 have the signature is a -> Bool
both f1 f2 xs = filter f1 (filter f2 xs)
