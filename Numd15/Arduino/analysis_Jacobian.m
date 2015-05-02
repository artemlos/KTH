initdata

time = (time/(1000*60));

hold on


% Jacobian matrix:
J = @(t,k,l) [exp(-k*t) -l*t.*exp(-k*t)]
1
% Functions
f = @(t,k,l) l*exp(-k*t);

% I guess the solution to be close to (0,0)
x=[5 5]',iter=0, dxnorm=1;

while dxnorm>0.5e-4 & iter < 20
    fval = f(time, x(1),x(2))-temp;
    jval = J(time, x(1), x(2));
    dx = -jval\fval;
    x= x+dx;
    dxnorm=norm(dx,inf), iter=iter+1;
end
x,iter
hold on
%
%plot(time,temp);
time = -1000:0.1:1000;
plot(time, f(time, x(1),x(2)))

axis square
title('Temperature vs. Time')
xlabel('Time (ms)')
ylabel('Temperature (C)')
hold off


