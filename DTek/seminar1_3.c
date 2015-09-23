#include <stdio.h>

void adder (const int *x, const int *y, int *z) {
	*z = *x+*y;
}


int foo (int a) {
	const int k = 10;

	int result;

	adder (&a, &k, &result);

	return result;
}

int main () {
	printf("%d\n", foo(7));
}