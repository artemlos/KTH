% Solve x^2+y-11=0 and 2*x*y+y^2-16=0

% Jacobian matrix:
J = @(x,y) [2*x 1; 2*y 2*x+2*y]

% Functions
f = @(x,y) [x^2+y-11; 2*x*y+y^2-16];

% I guess the solution to be close to (0,0)
x=[0.1 0.1]',iter=0, dxnorm=1;

while dxnorm>0.5e-4 & iter < 10
    fval = f(x(1),x(2));
    jval = J(x(1),x(2));
    dx = -jval\fval;
    x= x+dx;
    dxnorm=norm(dx,inf), iter=iter+1;
end
x,iter

% we should get 3 and 2