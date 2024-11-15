/* O programa deve perguntar o nome do usuário e o dê as boas vindas ao programa conforme exemplo abaixo:

----------------Exemplo de execução------------------------------
Output: Qual o seu nome?
Input: Felipe
Output: Ola, Felipe
----------------Fim do programa----------------------------------
*/

#include <stdio.h>

int main(){
    char nome[50];

    printf("Qual o seu nome?\n");
    scanf("%s", nome);

    printf("Ola, %s", nome);

    return 0;
}