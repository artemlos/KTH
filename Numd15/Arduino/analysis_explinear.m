initdata % run the script initdata that loads temp and time into memory

time = (time/(1000*60));

logtemp = log(temp);

A = [ones(length(time),1) -time];
coeff = A\logtemp;


hold on
%
plot(time,temp);
plot(time, exp(coeff(1))*exp(-coeff(2)*time));


r = norm(temp - A*coeff)

axis square
title('Temperature vs. Time')
xlabel('Time (ms)')
ylabel('Temperature (C)')
hold off


