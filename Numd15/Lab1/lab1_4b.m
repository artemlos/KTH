% This script will try to put a circle a that attempts to go through/close
% to the 10 points points.

[x,y] = ginput(10)

A = [ones(10, 1) x y]
b = [x.^2 + y.^2]
c = A\b
a = c(2)/2
b = c(3)/2
Rsq = c(1) + a^2 + b^2

viscircles([a,b],sqrt(Rsq))