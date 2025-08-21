def busca(lista, valor, posicao) -> int:

    while posicao < len(lista) and lista [posicao] != valor:
        posicao = posicao + 1

    if posicao == len(lista):
        return -1
    else:
        return posicao




def busca_par (lista:list , soma: int):
    i = 0
    while i < len(lista):
        comparativo = soma - lista[i]
        resposta = busca(lista, comparativo, i)

        if resposta != -1:
            print(f'({lista[i]}, {lista[resposta]})')
        i = i + 1

if __name__ == "__main__":
    lista = [2, 5, -7, 9, 3, 10, 15, 6]
    busca_par(lista, 11)