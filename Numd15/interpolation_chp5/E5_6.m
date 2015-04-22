% we are given three curves: z(x,0.5)=1+x^3, z(x,1)= 1-1.5x+2.5x^2,
% z(x,2)= 1+sin(pi*x/2). These make up a roof for a rectangle (in
% xy-plane).

y=[0.5 1 2]'; dx=0.2; dy=0.25;

for j=1:2
    x=0:dx:1;
    z1 = 1+x.^3;
    z2 = 1-1.5*x+2.5*x.^2;
    z3 = 1+sin(pi*x/2); 
    subplot(2,2,j); fill3([0 0 0 1],[0.0 2 2 0.5], [0 0 0 0],'c')
    hold on
    axis([0 1 0.5 2 0 2])
    
    for k=1:3
        plot3([0 0 1 1],y(k)*[1 1 1 1],[1 0 0 2]);
    end
    
    zmat = [z1; z2; z3];
    
    A =[ones(3,1) y y.^2];
    C=A\zmat; %interpolation
    yy = (0.5:dy:2)';
    Z=[ones(size(yy)) yy yy.^2]*C;
    X=ones(size(yy))*x;
    Y=yy*ones(size(x));
    surf(X,Y,Z);
    
    dx=dy/2; dy=dy/2;
end
