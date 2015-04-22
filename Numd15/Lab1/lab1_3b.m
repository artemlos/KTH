% polynom

%A = [1 91 91^2; 1 121 121^2; 1 152 152^2; 1 182 182^2; 1 213 213^2; 1 244 244^2]

K = [91 121 152 182 213 244]'

A =[ones(6,1) K K.^2];

b = [13.2 15.8 18.0 18.4 16.6 14.1]'

x = A\b

xaxis = 80:0.01:265;

plot(xaxis, polyval(fliplr(x'),xaxis))

%polyval(fliplr(x'),91)

% solve equation