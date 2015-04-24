data = importdata('data.txt');

time = data(1:2:length(data)); % the time
temp = data(2:2:length(data)); % the temperature

hold on
plot(time,temp);

%%
%testing with polynomials
A = [ones(length(time),1) time time.^2];

cond(A) % a great value -> not good -> small disturbance -> big differences.

%%
B = [ones(length(time),1) 1./time];

cond(B)  % smaller than before -> better but not perfect.

%%
C = [ones(length(time),1) 1./time 1./(time.^2)];

cond(C)  % worse.

%%

D = [1./time]; 

cond(D)  % Am I wrong? it's 1. that's good in constrast to the previous results.

coeff = D\temp;

%plot(time,coeff(1)./time); % not good, let us use B.

coeff = B\temp;
plot(time,coeff(1)+coeff(2)./time);
