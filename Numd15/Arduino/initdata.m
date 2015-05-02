%%
% First, we need to import the data from file
data = importdata('data2.txt');

format long

%parsing the data into two vectors
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