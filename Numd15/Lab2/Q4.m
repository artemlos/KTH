ds2 = @(t,s) s(1)/9 - s(1)*pi*exp(t/3)*(2*s(2)*sin(pi*t)+pi*s(1)*cos(pi*t))
f = @(t,s) [s(2); ds2(t,s)]'

tslut = 6;
t = 0;

 h= 0.1;
 Y = [];
 T = [];
 y = [1 -1/3]
 while t < tslut
     f1 = f(t,y);
     f2 = f(t+h/2,y+h*f1/2);
     f3 = f(t+h/2,y+h*f2/2);
     f4 = f(t+h,y+h*f3);
     
     T=[T;t];
     Y=[Y;y];
     
     y = y +(h/6)*(f1+2*f2+2*f3+f4);
     t = t+h; 
     
 end
 
L = Y(:,1)
L(end) % 0.219431472260047 för h=0.1
L(end) % 0.305364907441336 för h=0.2
 
figure
plot(T,Y)

phi = 0:2*pi/30:2*pi;

X = T*ones(size(phi));
Y2 = Y(:,1)*cos(phi);
Z = Y(:,1)*sin(phi);
figure
mesh(X,Y2,Z)
figure
surf(X,Y2,Z)