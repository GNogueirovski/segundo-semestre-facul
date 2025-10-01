def menu_principal() -> int:
    print("\nSeja bem-vindo ao Menu do Colaborador do ELO IMREA")
    print("\n===== MENU PRINCIPAL =====")
    print("1) Gerenciar Médicos")
    print("2) Gerenciar Pacientes")
    print("3) Consultas")
    print("4) Sair")
    while True:
        try:
            opcao = int(input("Escolha uma opção: "))
            if 1 <= opcao <= 4:
                return opcao
            else:
                print("Opção inválida. Digite um número entre 1 e 4.")
        except ValueError:
            print("Entrada inválida! Digite apenas números.")


def menu_crud(entidade: str) -> int:
    print(f"\n===== GERENCIAR {entidade.upper()} =====")
    print("1) Criar")
    print("2) Listar")
    print("3) Atualizar")
    print("4) Excluir")
    print("5) Voltar")
    while True:
        try:
            opcao = int(input("Escolha uma opção: "))
            if 1 <= opcao <= 5:
                return opcao
            else:
                print("Opção inválida. Digite uma opção entre 1 e 5.")
        except ValueError:
            print("Entrada inválida! Digite apenas números.")


def menu_consultas() -> int:
    print("\n===== GERENCIAR CONSULTAS =====")
    print("1) Marcar Consulta")
    print("2) Listar Consultas")
    print("3) Atualizar Consulta")
    print("4) Cancelar Consulta")
    print("5) Voltar")
    while True:
        try:
            opcao = int(input("Escolha uma opção: "))
            if 1 <= opcao <= 5:
                return opcao
            else:
                print("Opção inválida. Digite uma opção entre 1 e 5.")
        except ValueError:
            print("Entrada inválida! Digite apenas números.")


def validar_cpf(cpf: str) -> bool:
    return cpf.isdigit() and len(cpf) == 11


def buscar_por_cpf(repositorio: list, cpf: str) -> dict:
    for item in repositorio:
        if item["cpf"] == cpf:
            return item
    return None


# CRUD Médicos
def criar_medico(medicos: list):
    try:
        print("\n=== Cadastro de Médico ===")
        nome = input("Nome completo: ")
        data_nasc = input("Data de nascimento: ")

        while True:
            cpf = input("CPF (11 dígitos): ")
            if validar_cpf(cpf):
                if buscar_por_cpf(medicos, cpf):
                    print("CPF já cadastrado!")
                else:
                    break
            else:
                print("CPF inválido!")

        crm = input("CRM: ")
        especialidade = input("Especialidade: ")
        telefone = input("Telefone: ")
        email = input("E-mail institucional: ")

        medico = {
            "nome": nome,
            "data_nasc": data_nasc,
            "cpf": cpf,
            "crm": crm,
            "especialidade": especialidade,
            "telefone": telefone,
            "email": email
        }
        medicos.append(medico)
    except Exception as e:
        print(f"Erro ao cadastrar médico: {e}")
    else:
        print("Médico cadastrado com sucesso!")
    finally:
        print("Operação finalizada.\n")


def listar_medicos(medicos: list):
    if not medicos:
        print("Nenhum médico cadastrado.")
        return
    print("\n=== Lista de Médicos ===")
    for medico in medicos:
        print(f"- {medico['nome']} ({medico['especialidade']}) CPF: {medico['cpf']}")


def atualizar_medico(medicos: list):
    cpf = input("Digite o CPF do médico a ser atualizado: ")
    medico = buscar_por_cpf(medicos, cpf)
    if not medico:
        print("Médico não encontrado!")
        return
    try:
        print("Deixe em branco para não alterar.")
        novo_tel = input(f"Telefone atual ({medico['telefone']}): ")
        novo_email = input(f"E-mail atual ({medico['email']}): ")
        if novo_tel:
            medico["telefone"] = novo_tel
        if novo_email:
            medico["email"] = novo_email
    except Exception as e:
        print(f"Erro ao atualizar: {e}")
    else:
        print("Médico atualizado com sucesso!")
    finally:
        print("Operação finalizada.\n")


def excluir_medico(medicos: list):
    cpf = input("Digite o CPF do médico a ser removido: ")
    medico = buscar_por_cpf(medicos, cpf)
    if not medico:
        print("Médico não encontrado!")
        return
    try:
        medicos.remove(medico)
    except Exception as e:
        print(f"Erro ao excluir: {e}")
    else:
        print("Médico removido com sucesso!")
    finally:
        print("Operação finalizada.\n")


# CRUD Pacientes
def criar_paciente(pacientes: list):
    try:
        print("\n=== Cadastro de Paciente ===")
        nome = input("Nome completo: ")
        data_nasc = input("Data de nascimento (dd/mm/aaaa): ")

        while True:
            cpf = input("CPF (11 dígitos): ")
            if validar_cpf(cpf):
                if buscar_por_cpf(pacientes, cpf):
                    print("CPF já cadastrado!")
                else:
                    break
            else:
                print("CPF inválido!")

        telefone = input("Telefone: ")
        email = input("E-mail: ")
        diagnostico = input("Diagnóstico: ")

        paciente = {
            "nome": nome,
            "data_nasc": data_nasc,
            "cpf": cpf,
            "telefone": telefone,
            "email": email,
            "diagnostico": diagnostico
        }
        pacientes.append(paciente)
    except Exception as e:
        print(f"Erro ao cadastrar paciente: {e}")
    else:
        print("Paciente cadastrado com sucesso!")
    finally:
        print("Operação finalizada.\n")


def listar_pacientes(pacientes: list):
    if not pacientes:
        print("Nenhum paciente cadastrado.")
        return
    print("\n=== Lista de Pacientes ===")
    for paciente in pacientes:
        print(f"- {paciente['nome']} (CPF: {paciente['cpf']}) Diagnóstico: {paciente['diagnostico']}")


def atualizar_paciente(pacientes: list):
    cpf = input("Digite o CPF do paciente a ser atualizado: ")
    paciente = buscar_por_cpf(pacientes, cpf)
    if not paciente:
        print("Paciente não encontrado!")
        return
    try:
        print("Deixe em branco para não alterar.")
        novo_tel = input(f"Telefone atual ({paciente['telefone']}): ")
        novo_email = input(f"E-mail atual ({paciente['email']}): ")
        if novo_tel:
            paciente["telefone"] = novo_tel
        if novo_email:
            paciente["email"] = novo_email
    except Exception as e:
        print(f"Erro ao atualizar: {e}")
    else:
        print("Paciente atualizado com sucesso!")
    finally:
        print("Operação finalizada.\n")


def excluir_paciente(pacientes: list):
    cpf = input("Digite o CPF do paciente a ser removido: ")
    paciente = buscar_por_cpf(pacientes, cpf)
    if not paciente:
        print("Paciente não encontrado!")
        return
    try:
        pacientes.remove(paciente)
    except Exception as e:
        print(f"Erro ao excluir: {e}")
    else:
        print("Paciente removido com sucesso!")
    finally:
        print("Operação finalizada.\n")


# CRUD Consultas
def marcar_consulta(consultas: list, pacientes: list, medicos: list):
    if not pacientes:
        print("Não há pacientes cadastrados.")
        return
    if not medicos:
        print("Não há médicos cadastrados.")
        return

    cpf_paciente = input("Digite o CPF do paciente: ")
    paciente = buscar_por_cpf(pacientes, cpf_paciente)
    if not paciente:
        print("Paciente não encontrado.")
        return

    especialidade = input("Digite a especialidade da consulta: ")
    medico = None
    for m in medicos:
        if m["especialidade"].lower() == especialidade.lower():
            medico = m
            break

    if not medico:
        print("Nenhum médico encontrado com essa especialidade.")
        return

    data = input("Digite a data da consulta (dd/mm/aaaa): ")
    hora = input("Digite a hora da consulta (hh:mm): ")
    local = input("Digite o local da consulta: ")

    consulta = {
        "paciente": paciente,
        "medico": medico,
        "especialidade": especialidade,
        "data": data,
        "hora": hora,
        "local": local,
        "status": "Agendada"
    }

    consultas.append(consulta)
    print(f"Consulta marcada com Dr(a). {medico['nome']} para o paciente {paciente['nome']}.")


def listar_consultas(consultas: list):
    if not consultas:
        print("Nenhuma consulta marcada.")
        return
    print("\n=== Lista de Consultas ===")
    for i, consulta in enumerate(consultas, start=1):
        print(f"{i}) Paciente: {consulta['paciente']['nome']} - Médico: Dr(a). {consulta['medico']['nome']} "
              f"({consulta['especialidade']}) em {consulta['data']} às {consulta['hora']} - Local: {consulta['local']} "
              f"- Status: {consulta['status']}")


def atualizar_consulta(consultas: list):
    listar_consultas(consultas)
    if not consultas:
        return
    try:
        idx = int(input("Digite o número da consulta que deseja atualizar: ")) - 1
        if idx < 0 or idx >= len(consultas):
            print("Consulta inválida.")
            return

        consulta = consultas[idx]
        print("Deixe em branco para não alterar.")
        nova_data = input(f"Data atual ({consulta['data']}): ")
        nova_hora = input(f"Hora atual ({consulta['hora']}): ")
        novo_local = input(f"Local atual ({consulta['local']}): ")

        if nova_data:
            consulta["data"] = nova_data
        if nova_hora:
            consulta["hora"] = nova_hora
        if novo_local:
            consulta["local"] = novo_local

    except Exception as e:
        print(f"Erro ao atualizar consulta: {e}")
    else:
        print("Consulta atualizada com sucesso!")
    finally:
        print("Operação finalizada.\n")


def excluir_consulta(consultas: list):
    listar_consultas(consultas)
    if not consultas:
        return
    try:
        idx = int(input("Digite o número da consulta que deseja cancelar: ")) - 1
        if idx < 0 or idx >= len(consultas):
            print("Consulta inválida.")
            return
        consultas.pop(idx)
    except Exception as e:
        print(f"Erro ao excluir consulta: {e}")
    else:
        print("Consulta cancelada com sucesso!")
    finally:
        print("Operação finalizada.\n")


def main():
    medicos = []
    pacientes = []
    consultas = []

    while True:
        opcao = menu_principal()
        if opcao == 1:
            while True:
                sub = menu_crud("Médicos")
                if sub == 1:
                    criar_medico(medicos)
                elif sub == 2:
                    listar_medicos(medicos)
                elif sub == 3:
                    atualizar_medico(medicos)
                elif sub == 4:
                    excluir_medico(medicos)
                elif sub == 5:
                    break

        elif opcao == 2:
            while True:
                sub = menu_crud("Pacientes")
                if sub == 1:
                    criar_paciente(pacientes)
                elif sub == 2:
                    listar_pacientes(pacientes)
                elif sub == 3:
                    atualizar_paciente(pacientes)
                elif sub == 4:
                    excluir_paciente(pacientes)
                elif sub == 5:
                    break

        elif opcao == 3:
            while True:
                sub = menu_consultas()
                if sub == 1:
                    marcar_consulta(consultas, pacientes, medicos)
                elif sub == 2:
                    listar_consultas(consultas)
                elif sub == 3:
                    atualizar_consulta(consultas)
                elif sub == 4:
                    excluir_consulta(consultas)
                elif sub == 5:
                    break

        elif opcao == 4:
            print("Encerrando o sistema. Obrigado por usar o ELO IMREA!")
            break

if __name__ == "__main__":
    main()
