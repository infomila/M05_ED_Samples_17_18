#include <stdio.h>
#include "Programa.h"
#include "Funcions.h"
#include <conio.h>

void main(int argn, char **argv) {

	saluda();
	int resultat = suma(2, 3);
	printf("%d", resultat);
	getchar();
		 
}

void saluda() {
	printf("Hola !!!!");
}
