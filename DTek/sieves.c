/*
 print-prime.c
 By David Broman.
 Last modified: 2015-09-15
 This file is in the public domain.
Artem
*/


#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>

#define COLUMNS 6
#define GET_POSITION(x) (x-2)
#define true 1
#define false 0

int current = 0; // to get a side effect.

void print_number(int n) {
	printf("%d\t", n);
	if (current == COLUMNS-1) {
	putchar('\n');
	current = 0;
	} else {
	current++;
	}
}

int is_prime(int n){

	int i, s;
	s = 1;

	for (i = 2; (i*i <= n) && s; i++) {
		if (n%i==0)
			s = 0;
		else
			s = 1;

	}
		
	return s;
}



void print_sieves (int n) {
	int m = 0;
	int prev = 0;
	uint8_t A[n];
	
	// make sure that A has true values only.
	int i, j;
	for (i = 0; i < n; i++) {
		A[i] = true;
	}
	
	for (i = 2; i*i < n; i++) {
		if (A[i]) {
			for (j = i*i; j < n; j+=i) {
				A[j] = false;
			}
			
		}	
	}

	for (i=2; i < n; i++) {
		if (A[i]) {
			if (i-prev == 8)
				m++;
			prev = i;
			print_number(i);
		}	
	}
	printf("N= %d\n", m);
}

void print_primes(int n){
  // Should print out all prime numbers less than 'n'
  // with the following formatting. Note that
  // the number of columns is stated in the define
  // COLUMNS

 	int i;
	for (i=2; i < n+2;i++) {
		if (is_prime(i)) {
			print_number(i);
		}
	}

  printf("\n");
}

// 'argc' contains the number of program arguments, and
// 'argv' is an array of char pointers, where each
// char pointer points to a null-terminated string.
int main(int argc, char *argv[]){
  if(argc == 2)
    print_sieves(atoi(argv[1]));
  else
    printf("Please state an interger number.\n");
  return 0;
}

 

