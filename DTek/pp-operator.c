#include <stdio.h>

int main() {
	int x = 0;
	x = ++x + x++; // returns 3
	printf("%d\n", x );

	x=0;
	x = x++ + x++; // returns 1
	printf("%d\n", x );

	x=0;
	x = ++x + ++x; // returns 4
	printf("%d\n", x );


	return 0;
}