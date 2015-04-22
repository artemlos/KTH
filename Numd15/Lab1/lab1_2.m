function main
    n = input('Enter a number from 5 to 10 inclusive: ')
    [A,b] = illposed(n)
    
    x = A\b % solving the system
    
    table = [];
    
    for i = 3:-1:1
        bs = b + -10^(-i)*ones(n,1);
        
        xs = A\bs;
        
        R_in = norm(bs - b)/norm(b);
        R_out = norm(xs - x)/norm(x);
        
        row = [R_out/R_in cond(A)];
        
        table = [table; row];
    end
    
    table
end


function [A,b] = illposed(n)
% ILLPOSED Creates an ill-posed system Ax=b.
%    ILLPOSED(N) creates an ill-posed system of size N.
%    N >= 2
%
%    See also RAND, EYE, ZEROS

% �Pedher Johansson
% Ume� University
% pedher@cs.umu.se
    if ~isnumeric(n)
         error('N must be an integer');
    end
    n = int16(n);
    
    if length(n) > 1
         error('N must be a scalar');
    end
    
    if n < 2
         error('N must be at least 2');
    end
    
    r = max(int16(round(0.25*n)),1);
    [U,S,V] = svd(rand(n));
    S(n-r+1:n,n-r+1:n) = diag(linspace(1.5e-9,2.45e-12,r));
    A = U*S*V';
    b = A*rand(n,1);

end