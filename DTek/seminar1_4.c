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


void square_reverse (const double in[], double out[], const int length) {
	int i;
	for (i = 0; i < length; i++) {
		out[length-i-1] = in[i] * in[i];
	}

}

int main () {
	double a[] = {11.0, 20.0, 100.0};
	double b[3];

	square_reverse(a,b,3);
	//printf("%d\n", foo(7));
	printf("%lf\n", b[0]);
	printf("%lf\n", b[1]);
	printf("%lf\n", b[2]);
}