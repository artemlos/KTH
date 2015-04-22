A1 = [0 4 5 7;1 2 3 0;1 1 -1 0;1 1 1 1]
A2 = [0 4 5;1 2 3;1 1 -1;1 1 1]
b = [6 5 1 2]'
x1 = A1\b
x2 = A2\b
res1 = b - A1*x1
res2 = b - A2*x2
n1 = norm(res1)
n2 = norm(res2)
n2 - n1