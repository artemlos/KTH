% We now work with k = y''/(1+(y')^2)^(3/2), k = 0.5*cos(x)


%%
% In the first part, we want to solve the DE for different initial values.

% the set of functions. alternatively, use sqrt and then raise to the power
% of three, i.e. for ^1.5
func = @(t, u) [u(2); 0.5*cos(t)*(1+u(2).^2).^(1.5)];

% this is the relative tolerance
rtol = 1e-5; 

hold on
for alpha = -0.1:0.1:0.5
    init = [0 alpha]'; % initial condition.
    [T,U] = ode45(func,[0 12]', init, rtol);
    % we want to graph the y value (it has 2 columns, but we only need the
    % y solution (note, we solve two systems at once since ODE is of the
    % second order).
    plot(T,U(:,1));
end

%%
% In the second part, we are given a condition, namely that it is know that
% y(12)=4. We can use this together with what was obtained in the first
% part to get some good initial guess to the following problem:
%   Solve: g(alpha)=0, where g(alpha)=y_end(alpha) -4, i.e. the deviation.
% We can solve this using secant method. 

% We know (based on part1) that alpha value between 0.2 and 0.3
alpha1 = 0.2;
[T,U] = ode45(func, [0 12], [0 alpha1], rtol);

g1=U(end,1)-4 
alpha2 = 0.3;
h= 0.1;
dx = 1
while abs(dx) > 0.5e-6
    [T, U] = ode45(func, [0 12], [0 alpha2], rtol);
    g2 = U(end,1)-4;
    dx = -g2*(alpha2-alpha1)/(g2-g1);
    alpha1=alpha2;
    g1=g2;
    alpha2 = alpha2 + dx;
end

alpha2 % this is our new alpha that will end up with a y_end close to 4.
U(end,1) % equal to approx. 4
plot(T,U(:,1),'.')
