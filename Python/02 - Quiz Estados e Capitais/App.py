import os
import random

estados_e_capitais = [{'estado':'Acre', 'capital':'Rio Branco'},
                      {'estado':'Alagoas', 'capital':'Maceió'},
                      {'estado':'Amapá', 'capital':'Macapá'}]

nao_respondidos = []

def adicionar_questoes():
    for item in estados_e_capitais:
        estado = item['estado']
        capital = item['capital']
        dados_item_estado = {'questão':estado, 'resposta':capital}
        dados_item_capital = {'questão':capital, 'resposta':estado}
        nao_respondidos.append(dados_item_estado)
        nao_respondidos.append(dados_item_capital)

def exibir_titulo():
    print("Quiz dos Estados e Capitais\n")

def verificar_resposta():
    pontos = 0
    input("Digite enter para iniciar")

    while len(nao_respondidos) > 0:
        os.system('cls')
        exibir_titulo()
        item_aleatorio = random.choice(nao_respondidos)
        questao = item_aleatorio['questão']
        resposta_correta = item_aleatorio['resposta']
        resposta_input = input(f"{questao}: ")

        if resposta_input == resposta_correta:
            pontos += 1
            print(f"\nVocê acertou! ({pontos} de {(len(estados_e_capitais) * 2)})")
            for item in nao_respondidos:
                if questao == item['questão']:
                    nao_respondidos.remove(item)
                    break
        else:
            print("\nVocê errou")

        input("\nDigite enter para continuar")
    
    fim_de_jogo()

def fim_de_jogo():
    os.system('cls')
    print("Você terminou o quiz")
    opcao_escolhida = input("\nJogar novamente? Digite s para sim, ou n para não: ").lower()
    os.system('cls')

    if opcao_escolhida == 's':
        adicionar_questoes()
        exibir_titulo()
        verificar_resposta()

def main():
    os.system('cls')
    adicionar_questoes()
    exibir_titulo()
    verificar_resposta()

if __name__ == '__main__':
    main()