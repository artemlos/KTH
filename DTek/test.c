#include <stdio.h>

int impl(int a) {
	int b = 3;
	return 2*a*b;
}

int func(int a) {
	return 3*a;
}


int main(void) {
	int (*funcp)(int);
	funcp = &func;
	printf("%d\n", *funcp);
	printf("%d\n", &funcp);
		
	funcp = &impl;
	printf("%d\n", *funcp);
	printf("%d\n", &funcp);
	
	*funcp == impl;
}
