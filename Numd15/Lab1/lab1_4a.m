% interpolation
x = [-2 -1 2 -1 1 3]';
y = [2 5 4 0 0 1]';
A = [ones(6, 1) x y]
b = [x.^2 + y.^2]
c = A\b
a = c(2)/2
b = c(3)/2
Rsq = c(1) + a^2 + b^2


% minsta kvadrat metoden
x1 = [-2 -1 2]';
y1 = [2 5 4]';
A1 = [ones(3, 1) x1 y1]
b1 = [x1.^2 + y1.^2]
c1 = A1\b1
a1 = c1(2)/2
b1 = c1(3)/2
Rsq1 = c1(1) + a1^2 + b1^2



hold off

viscircles([a,b],sqrt(Rsq))
viscircles([a1,b1],sqrt(Rsq1), 'EdgeColor','b')