import os

lista_de_restaurantes = [{'nome':'pizzaria top', 'categoria':'comida italiana', 'ativo':False},
                {'nome':'los pollos hermanos', 'categoria':'frango frito', 'ativo':True},
                {'nome':'hamburgão do ronaldo', 'categoria':'hambúrguer', 'ativo':False}]

def exibir_nome_do_programa():
    print("Aplicativo de Restaurantes\n")

def exibir_opcoes():
    print("1. Cadastrar restaurante")
    print("2. Listar restaurantes")
    print("3. Ativar restaurante")
    print("4. Sair\n")

def escolher_opcao():
    try:
        opcao_escolhida = int(input("Escolha uma opção: "))

        if opcao_escolhida == 1:
            cadastrar_restaurante()
        elif opcao_escolhida == 2:
            listar_restaurantes()
        elif opcao_escolhida == 3:
            alternar_status_restaurante()
        elif opcao_escolhida == 4:
            finalizar_app()  
        else:
            opcao_invalida()
    except:
        opcao_invalida()

def cadastrar_restaurante():
    exibir_subtitulo("Cadastrando restaurante")

    nome_restaurante = input("Digite o nome do restaurante que deseja cadastrar: ")
    categoria_restaurante = input(f"\nDigite a categoria do restaurante {nome_restaurante}: ")
    dados_do_restaurante = {'nome':nome_restaurante, 'categoria':categoria_restaurante, 'ativo':False}
    lista_de_restaurantes.append(dados_do_restaurante)
    print(f"\nO restaurante {nome_restaurante.title()} foi cadastrado com sucesso")

    voltar_ao_menu_principal()

def listar_restaurantes():
    exibir_subtitulo("Listar restaurantes")

    legenda = f" {"Nome".ljust(21)} | {"Categoria".ljust(20)} | {"Status".ljust(20)}"
    linha = "-" * len(legenda)
    print(legenda)
    print(linha)

    for restaurante in lista_de_restaurantes:
        nome_restaurante = restaurante['nome'].title() # O método title() torna a primeira letra de cada palavra maiúscula
        categoria_restaurante = restaurante['categoria'].title()
        status_restaurante = "Ativo" if restaurante['ativo'] else "Desativado"
        print(f"- {nome_restaurante.ljust(20)} | {categoria_restaurante.ljust(20)} | {status_restaurante}")

    voltar_ao_menu_principal()

def alternar_status_restaurante():
    exibir_subtitulo("Ativar / Desativar restaurante")

    nome_restaurante = input("Digite o nome do restaurante que deseja alternar o status: ")
    restaurante_encontrado = False

    for restaurante in lista_de_restaurantes:
        if restaurante['nome'].lower() == nome_restaurante.lower():
            restaurante_encontrado = True
            restaurante['ativo'] = not restaurante['ativo']
            status_restaurante = "ativado" if restaurante['ativo'] else "desativado"
            print(f"\nO restaurante {nome_restaurante.title()} foi {status_restaurante} com sucesso")
    
    if not restaurante_encontrado:
        print("\nO restaurante informado não foi encontrado")

    voltar_ao_menu_principal()

def finalizar_app():
    exibir_subtitulo("Finalizando app")

def voltar_ao_menu_principal():
    input("\nDigite enter para voltar ao menu principal ")
    main()

def opcao_invalida():
    exibir_subtitulo("Opção inválida")
    voltar_ao_menu_principal()

def exibir_subtitulo(texto):
    os.system('cls')
    linha = '-' * len(texto)
    print(linha)
    print(texto)
    print(linha)
    print()

def main():
    os.system('cls')
    exibir_nome_do_programa()
    exibir_opcoes()
    escolher_opcao()

if __name__ == '__main__':
    main()