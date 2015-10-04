far(anton,petter).
mor(anton, agnes).
mor(petter,anna).
farmor(X,Y) :- far(X, Z), mor(Z,Y).

forelder(X,Y) :- far(X,Y).
forelder(X,Y) :- mor(X,Y).

fib(0,1).
fib(1,1).
fib(X,Y) :- fib(X-1,Y-1).


