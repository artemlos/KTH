% Keep in mind that input has to be transposed (column matrices)

angle=[55.7 57.7 59.3 62.6 65.6]';
time=[17+28/60 18 18+31/60 19+56/60 22+34/60]';

A =[ones(5,1) angle angle.^2 angle.^3 angle.^4];

constants = A\time;
answer = polyval(fliplr(constants'),61.7)



