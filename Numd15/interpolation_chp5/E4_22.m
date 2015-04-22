% using Gauss-Newton method to fit the datapoints to a model.

angles=[0 pi/6 pi/3 pi/2 2*pi/3 5*pi/6 pi 7*pi/6 4*pi/3 3*pi/2 5*pi/3 11*pi/6]';
radii=[3.3 3.5 2.7 2.0 1.4 1.0 0.7 0.5 0.4 0.5 0.9 1.9]';

numberOfDataPoints=length(angles);

% the model:

rfunc = @(r,angle,a,b,c) a+b.*sin(angle)-c.*r.*cos(angle);

Jfunc = @(r,angle) [ones(numberOfDataPoints,1) sin(angle) -r.*cos(angle)];

% starting value for a,b,c
a=1, b=1, c=-1

coeff=[a b c]';

for iter=1:5
   rval = rfunc(radii,angles,a,b,c) - radii; % kanske -r så att f(x)=0?
   Jval = Jfunc(radii,angles);
   dc = -Jval\rval;
   coeff=coeff+dc;
   a=coeff(1);b=coeff(2); c=coeff(3);
end

coeff