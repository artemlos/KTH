data = importdata('data.txt');

time = data(1:2:length(data)); % the time
temp = data(2:2:length(data)); % the temperature

%plot(time,temp);

%%
% the first part is not important as the termometer is increasing its
% tempreature

start = max(temp);

pos = find(start == temp);

newStartTime = time(pos);

temp = temp(pos:1:length(temp));
time = time(pos:1:length(time));

%plot(time,temp);

time = time - ones(length(time),1).*newStartTime;

%plot(time,temp);

%plot(time,temp)
%hold on
%plot(time,log(log(temp))
%hold on

%A = [ones(length(time),1) exp(-time)];

%A = [ones(length(time),1) exp(-time)];

A = [ones(length(time),1) time.^(-1)];


x = A\temp;

%plot(time,temp);
axis square
%plot(time,x(1).*time);

plot(time,temp);
hold on
plot(time,polyval(fliplr(x'),time));

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
