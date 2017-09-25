#include <conio.h>
#include <stdio.h>
#include "include\Funcions.h"
void main(int argn, char **argv) {
	printf("Estic usant una DLL !!!");

	double resultat = suma(1234, 234);

	printf("%lf", resultat);
	getchar();

}