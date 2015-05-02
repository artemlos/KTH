f = @(t,y) (y*t-100)

n = 1000 % step length

% init.
t = 1;
y = 1;

interval = [0 5]

h = (interval(2)-interval(1))/n

xaxis = [];
yaxis =[];
for i=1:n
    t = t + h;
    y = y + h*f(t,y);
    
    xaxis =[xaxis;t];
    yaxis = [yaxis;y];
end

hold on
plot(xaxis,yaxis)


%a,b = EulerM(f,[0 5], [1 1], 1000)


hold off
    
    