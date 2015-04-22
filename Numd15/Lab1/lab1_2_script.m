    format long g
    n = input('Enter a number from 5 to 10 inclusive: ')
    [A,b] = illposed(n)
    
%     A=rand(n,n);
%     b=rand(n,1);
%     
    x = A\b; % solving the system
    
    table = [];
    
    for i = 3:-1:1
        bs = b -10^(-i)*ones(n,1);
        
        xs = A\bs;
        
          bs = b -10^(-i)*ones(n,1);
        
        xs = A\bs;
        
        R_in = norm(bs - b)/norm(b);
        R_out = norm(xs - x)/norm(x);
        
        row = [R_in R_out R_out/R_in cond(A)];
        
        table = [table; row];
    end
    header= {'R_in', 'R_out','R_out/R_in', 'cond(A)'}
    output = {header; table }
    
    for i = 1:2
        output{i}
    end

