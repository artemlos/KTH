%% Finding Mass of Atoms (Experimentally)
% We are given the molecular masses of $NO, N_2O, NO_2, N_2O_5$, located in
% exp_values.

% In matrix form
A = [1 1
     2 1
     1 2
     2 5];
 
 % Experimental
 exp_values = [30.006; 44.013; 46.006; 108.010];
 
 % The answers
 x = A\exp_values
 
 %%
 % Thus, the atomic mass of N is $14.0069$ and O is $15.9993$.