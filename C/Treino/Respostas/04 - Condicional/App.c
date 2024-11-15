/* O programa deve perguntar a idade do usuario e informar se ele eh maior de idade ou nao conforme exemplos abaixo:
----------Exemplo de execução-----------------
Output: Quantos anos voce tem?
Input: 20
Output: Você eh maior de idade
----------Fim do programa---------------------
----------Exemplo de execução-----------------
Output: Quantos anos voce tem?
Input: 15
Output: Você eh menor de idade
----------Fim do programa---------------------
*/

#include <stdio.h>

int main(){
    int idade;

    printf("Quantos anos voce tem?\n");
    scanf("%d", &idade);

    if (idade >= 18){
        printf("Voce eh maior de idade");
    } else {
        printf("Voce eh menor de idade");
    }

    return  0;
}