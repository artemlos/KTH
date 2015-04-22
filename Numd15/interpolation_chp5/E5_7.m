% Alterness of students in the interval of 45 min (during lecture)

time = 0:5:45;
percentage = [70 85 85 50 30 25 25 25 30 60 65];

% a) use only 0,10,20,30,40 and interpolate.
time_a = (0:10:40)';
percentage_a = percentage(1:2:9)';

A= [ones(5,1) time_a time_a.^2 time_a.^3 time_a.^4];

c=A\percentage_a;

plot(time_a, c);

% bad model.

%skipping b,c
% d)

