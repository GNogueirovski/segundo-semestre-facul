def buscaBinaria (vet, x):
    inicio = 0
    fim = len(vet) - 1
    while inicio <= fim:
        meio = (inicio+fim) // 2

        if vet[meio] > x:
            fim = meio - 1
        elif vet[meio] < x:
            inicio = meio + 1
        else:
            return meio
    return -1

vetor = [1, 2, 3, 4, 5, 6, 7, 8, 9]

print(buscaBinaria(vetor, 9))
            