def buscaFor(vet, x):
    for i in range (len(vet)):
        if vet[i] == x:
            return i
    return -1

def buscaWhile(vet, x):
    i = 0
    while i < len(vet) and vet[i] != x:
        i = i + 1
    if i == len(vet):
        return -1
    else:
        return i

vetor = [1, 2, 3, 4, 5, 6, 7, 8, 9]

print(buscaWhile(vetor, 3))