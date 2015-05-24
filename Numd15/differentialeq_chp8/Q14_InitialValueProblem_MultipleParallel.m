% We now work with k = y''/(1+(y')^2)^(3/2), k = 0.5*cos(x)

% the set of functions. alternatively, use sqrt and then raise to the power
% of three, i.e. for ^1.5
func = @(t, u) [u(2); 0.5*cos(t)*(1+u(2).^2).^(1.5)];

% this is the relative tolerance
rtol = 1e-5; 

hold on
for alpha = -0.1:0.1:0.5
    init = [0 alpha]'; % initial condition.
    [T,U] = ode45(func,[0 12]', init, rtol);
    plot(T,U);
end
