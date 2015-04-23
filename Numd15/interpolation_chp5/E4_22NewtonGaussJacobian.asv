%% First approach
% using Gauss-Newton method to fit the datapoints to a model.
% my conclusion can be found in the end of this file.

angles=[0 pi/6 pi/3 pi/2 2*pi/3 5*pi/6 pi 7*pi/6 4*pi/3 3*pi/2 5*pi/3 11*pi/6]';
radii=[3.3 3.5 2.7 2.0 1.4 1.0 0.7 0.5 0.4 0.5 0.9 1.9]';

numberOfDataPoints=length(angles);

% the model: it has been rewriten.

rfunc = @(r,angle,a,b,c) a+b.*sin(angle)-c.*r.*cos(angle);

Jfunc = @(r,angle) [ones(numberOfDataPoints,1) sin(angle) -r.*cos(angle)];

polar(angles,radii); hold on;

% starting value for a,b,c
a=1; b=1; c=-1;

coeff=[a b c]';
errors1 =[];
for iter=1:5
   rval = rfunc(radii,angles,a,b,c) - radii; % kanske -r så att f(x)=0?
   Jval = Jfunc(radii,angles);
   dc = -Jval\rval;
   coeff=coeff+dc;
   a=coeff(1);b=coeff(2); c=coeff(3);
   errors1 = [errors1;norm(rval)]; % we want this to decrease.
end
coeff

polar(angles,(a+b*sin(angles))./(1+c*cos(angles)));

%% Second way
% In this section, we will not rewrite the formula into another form but
% will use it as it is. This means we have a system f(x)=0 (f and x are vectors)
% that we need to solve using Newton-Gauss method.
% 1. We need to change rfunc
rfunc2 = @(angle,a,b,c) (a+b.*sin(angle))./(1+c.*cos(angle));

Jfunc2 = @(angle,a,b,c) [1./(1+c.*cos(angle)), sin(angle)./(1+c.*cos(angle)), (-(a+b.*sin(angle))./(1+c.*cos(angle)).^2).*cos(angle)];

% starting value for a,b,c
a=1.1986, b=0.7411, c=-0.6422

coeff=[a b c]';
errors1 =[];

for iter=1:5
   rval = rfunc2(angles,a,b,c) - radii; % kanske -r så att f(x)=0?
   Jval = Jfunc2(angles,a,b,c);
   dc = -Jval\rval;
   coeff=coeff+dc;
   a=coeff(1);b=coeff(2); c=coeff(3);
   errors1 = [errors1;norm(rval)]; % we want this to decrease.
end
coeff
errors1

polar(angles,rfunc2(angles,a,b,c));

%% Conclusion
% I think the reason I was asked to rewrite the formula in the first place,
% find the coeff and use those again but instead solving a system of
% equations with the original model is because the first method was good at
% finding the coeff. but maybe not as good at having a converging error. The
% original (unchanged) model, based on my observations, had a good converge
% if and only if we were close to the solutions.

