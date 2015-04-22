x = [1 3 4 5]';
y = [3 3 0 11]';

% an equation that goes through all points has to be of 
% fourth degree.

%% Naive approach

A = [ones(4,1) x x.^2 x.^3 x.^4]; % the naive approach.

%% Newton way
% ${c_1} + {c_2}(x - 1) + {c_3}(x - 1)(x - 3) + {c_4}(x - 1)(x - 3)(x - 4)$


c = A\y % constants of the polynomial

polyval(fliplr(c'),7) % value of P(7)
