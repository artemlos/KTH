initdata

%%

%the termometer had an uncertainty of 0.5C, and the results are within the
%operating interval

%temp = round(temp.*10)./10;
%temp = sprintf('%0.1f',temp)
%temp =floor(temp.*10)./10;

%%

hold on
plot(time,temp);

A =[ones(length(time),1) time]

x = A\temp;

hold on

plot(time,polyval(fliplr(x'),time));

r = norm(temp-A*x)

axis square
title('Temperature vs. Time')
xlabel('Time (ms)')
ylabel('Temperature (C)')
hold off


