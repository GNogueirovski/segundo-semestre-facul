import time
import busca_binaria
import busca_simples

def cria_lista(qtd: int) -> list:
    resp = []
    for i in range(qtd):
        resp.append(i)

    return resp

dados = cria_lista(5_000_000)

t_ini = time.time()
for i in range(1000):
    ret = busca_simples.buscaFor(dados, 7_000_000)
tempo = time.time() - t_ini
print(f"Busca demorou {tempo}s")

t_ini = time.time()
for i in range(1000):
    ret = busca_binaria.buscaBinaria(dados, 7_000_000)
tempo = time.time() - t_ini
print(f"Busca Binaria demorou {tempo}s")