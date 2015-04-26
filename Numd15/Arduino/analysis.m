data = importdata('data2.txt');

format long

time = data(1:2:length(data)); % the time
temp = data(2:2:length(data)); % the temperature

%%
% the first part is not important as the termometer is increasing its
% tempreature

start = max(temp);

pos = find(start == temp);

newStartTime = time(pos);

temp = temp(pos:1:length(temp));
time = time(pos:1:length(time));

time = time - ones(length(time),1).*newStartTime;
%%

%the termometer had an uncertainty of 0.5C, and the results are within the
%operating interval

%temp = round(temp.*10)./10;
%temp = sprintf('%0.1f',temp)
temp =floor(temp.*10)./10;
%%
time = time./1000;
time = time./(60); % minutes
plot(time,temp);
%logtemp = log(temp);
A = [ones(length(time),1) time.^(-1) time ];
%A = [ones(length(time),1) time];

x = A\logtemp;

x_diffmethod = inv(A'*A)*A'*logtemp; 
%inpaint_nans(x_diffmethod)
%axis square


hold on
%plot(time,exp(x(1))+exp(x(2).*time));
%plot(time,polyval(fliplr(x'),time));
%plot(time,polyval(fliplr(x_diffmethod'),time));

%plot(time, polyval(polyfit(time,temp,length(time)-1),time));

axis square
title('Temperature vs. Time')
xlabel('Time (ms)')
ylabel('Temperature (C)')
hold off


%plot(time, x(2)+x(1)*exp(-time))
% %%
% %testing with polynomials
% A = [ones(length(time),1) time time.^2];
% 
% cond(A) % a great value -> not good -> small disturbance -> big differences.
% 
% %%
% B = [ones(length(time),1) 1./time];
% 
% cond(B)  % smaller than before -> better but not perfect.
% 
% %%
% C = [ones(length(time),1) 1./time 1./(time.^2)];
% 
% cond(C)  % worse.
% 
% %%
% 
% D = [1./time]; 
% 
% cond(D)  % Am I wrong? it's 1. that's good in constrast to the previous results.
% 
% coeff = D\temp;
% 
% %plot(time,coeff(1)./time); % not good, let us use B.
% 
% coeff = B\temp;
% plot(time,coeff(1)+coeff(2)./time);
