def produto_escalar(matA: list, linha, matB: list, coluna):
    qtd_num = len(matA[linha])
    soma = 0

    i = 0
    while i < qtd_num:
        soma = soma + matA[linha][i] * matB[i][coluna]
        i = i + 1
    return soma

def multiplicacao(matA, matB):
    linA = len(matA) #qtd de linhas matriz a
    colB = len(matB[0]) #qtd de colunas da matriz b

    resultado = []
    for i in range(linA):
        resultado.append([0] * colB)

    for i in range(linA):
        for j in range(colB):
            resultado[i][j] = produto_escalar(matA, i, matB, j)

    return resultado


if __name__ == "__main__":
    matriz_a = [
        [3, 2, 1],
        [4, -1, 0]
    ]

    matriz_b = [
        [4, 0, 2, 1],
        [-1, 3, 1, -1],
        [1, 1, 7, 2]
    ]

    prod = multiplicacao(matriz_a, matriz_b)

    for lin in prod:
        print(lin)