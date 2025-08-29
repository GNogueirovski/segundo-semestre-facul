dadosConta = {}

def menu() -> int:
    print("\nSeja bem-vindo ao Sistema de Cadastro de Pix")
    print("Você deseja:")
    print("1) Cadastrar uma chave/conta")
    print("2) Consultar sua chave-pix")
    print("3) Sair do sistema")

    while True:
        try:
            opcao = int(input("Digite sua opção: "))
            if 1 <= opcao <= 3:
                return opcao
            else:
                print("Opção inválida. Digite uma opção entre 1 e 3")
        except ValueError:
            print("Entrada inválida. Por favor, digite um número entre 1 e 3")

def cadastro_conta (chave: str):
    if chave in dadosConta:
        return "Essa chave pix já foi utilizada."
    print("Informe seus dados bancários abaixo:")
    while True:
        try:
            conta = int(input("Digite o número da conta: "))
            break
        except ValueError:
            print("Entrada inválida, digite um número inteiro para a conta")

    nome = str(input("Digite o seu nome completo: "))
    banco = str(input("Digite o nome do banco: "))

    dadosConta[chave] = {
        "conta": conta,
        "nome": nome,
        "banco": banco
    }
    print("Chave pix cadastrada com sucesso!")


def consulta_conta (chave: str):
    if chave in dadosConta:
        print("=== Dados vinculados ao Pix ===")
        for key, value in dadosConta[chave].items():
            print(f"{key}: {value}")
    else:
        print("Não existe nenhuma conta vinculada a essa chave")

opcao = 0

if __name__ == "__main__":
    while opcao != 3:
        opcao = menu()
        if opcao == 1:
            chave_pix= str(input("Digite a chave pix (e-mail, telefone ou cpf) que deseja utilizar: "))
            cadastro_conta(chave_pix)
        elif opcao == 2:
            chave_pix = input("Digite a chave pix a ser procurada: ")
            consulta_conta(chave_pix)