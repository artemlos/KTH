#include <stdio.h>

//in swap(int*,int*);

int main() {
	
	int a = 1;
	int b=2;
	swap(&a, &b);

	printf("0x%x 0x%x", a, b );
	return 0;
	
}

int swap (int *a, int *b) {
	int t =0;
	t = *a;
	*a = *b;
	*b = t;
	return 0;
}