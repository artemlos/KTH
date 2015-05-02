function [ xaxis,yaxis ] = EulerM( f, interval, init, n )
%EulerM Summary of this function goes here
%   Detailed explanation goes here

    t = init(1);
    y = init(2);
    h = (interval(2)-interval(1))/n
    xaxis = [];
    yaxis = [];
    for i=1:n
        
        y = y + h*f(t,y);
        t = t + h;

        xaxis = [xaxis;t];
        yaxis = [yaxis;y];
    end

    return [xaxis,yaxis]
end

