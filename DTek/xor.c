#include <stdio.h>
#include <string.h>
#include <stdlib.h>

/*
 * Author: Artem Los (arteml@kth.se)
 */

char *encrypt(char[],char[]);

int main() {
	char a[8] = "test1";
	char key[10] = "hi";
	char *cipher = encrypt(a,key);
	free(cipher);
	printf("%s\n",cipher );

	return 0;
}

/*
 * Encrypts a message with XOR cipher.
 * Remember to free the dynamically allocated memory using free(cipher).
 */
char *encrypt(char message[], char key[]) {
	const int message_size = strlen(message);
	const int key_size = strlen(key);
	
	char *cipher = malloc(sizeof(char)*message_size);

	int i;
	for (i = 0; i < message_size; i++)
	{
		cipher[i]= (char)((int)message[i] ^ (int)key[i % key_size]);

	}
	return cipher;
}