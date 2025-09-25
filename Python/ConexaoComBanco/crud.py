import oracledb

def get_conexao() -> oracledb.Connection:
    conn = oracledb.connect(user = "rm563925", password="070602",
                            dsn="oracle.fiap.com.br:1521/orcl")
    return conn