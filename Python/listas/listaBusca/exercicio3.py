import busca_simples
def unique(lista: list) -> list:
    resp = []
    for elemento in lista:
        if busca_simples.buscaFor(resp, elemento) == -1:
            resp.append(elemento)
    return resp


if __name__ == "__main__":
    a = [2,4,0,3,2,6,3,7]
    listaSemRepeticao = unique(a)

    print(listaSemRepeticao)