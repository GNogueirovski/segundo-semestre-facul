/*2.1 Na tabela “T_CKP_CATEGORIA”, crie a instrução SQL, comando DDL para
alterar o nome da coluna “ds_sigla_categoria” para “ds_sigla_categ”.*/
ALTER TABLE t_ckp_categoria RENAME COLUMN ds_sigla_categoria TO ds_sigla_categ;

/*2.2 Na tabela “T_CKP_CATEGORIA”, crie a instrução SQL, comando DDL para
alterar o nome da UNIQUE constraint “UN_CKP_CATEGORIA_DESC” para “UN_CKP_CATEG_DESC”.*/
ALTER TABLE t_ckp_categoria RENAME CONSTRAINT un_ckp_categoria_desc TO un_ckp_categ_desc;

/*2.3 Na tabela “T_CKP_AUTOR”, crie a instrução SQL, comando DDL para
alterar o tamanho da coluna “nm_segundo_autor” para 30 caracteres.*/
ALTER TABLE t_ckp_autor MODIFY nm_segundo_autor VARCHAR2(30);

/*2.4 Na tabela “T_CKP_AUTOR”, crie a instrução SQL, comando DDL para
adicionar coluna “ds_email”, com tipo de dado VARCHAR2, tamanho 40
caracteres e obrigatória.*/
ALTER TABLE t_ckp_autor ADD ds_email VARCHAR2(40) NOT NULL;

/*2.5 Na tabela “T_CKP_AUTOR”, crie a instrução SQL, comando DDL para
alterar o tamanho da coluna “ds_email” para 60 caracteres e elimine a
constraint NOT NULL da coluna “ds_email”, utilizando uma única instrução.*/
ALTER TABLE t_ckp_autor MODIFY ds_email VARCHAR2(60) NULL;

/*2.6 Na tabela “T_CKP_AUTOR_LIVRO”, crie a instrução SQL, comando DDL
para alterar o tamanho da coluna “nr_isbn” para 13 dígitos.*/
ALTER TABLE t_ckp_autor_livro MODIFY nr_isbn NUMBER(13);

/*2.7 Na tabela “T_CKP_LIVRO”, crie a instrução SQL, comando DDL para alterar
o tamanho da coluna “nr_isbn” para 13 dígitos. Observe que esta coluna
é uma chave primária, uma vez alterada, se faz necessário alterar a chave
estrangeira também, como feito primeiramente no item 2.6.*/
ALTER TABLE t_ckp_livro MODIFY nr_isbn NUMBER(13);

/*2.8 Na tabela “T_CKP_AUTOR”, crie a instrução SQL, comando DDL para
alterar adicionar a coluna “nm_pais_origem” (nome do país de origem do
autor), com tipo de dado VARCHAR2, tamanho 30 caracteres e não
obrigatório (opcional).*/
ALTER TABLE t_ckp_autor ADD nm_pais_origem VARCHAR2(30);

/*2.9 Na tabela “T_CKP_LIVRO”, crie a instrução SQL, comando DDL para alterar
adicionar a constraint UNIQUE para a coluna “nm_titulo”. Nomeie a
constraint como: “UN_CKP_LIVRO_TITULO”.*/
ALTER TABLE t_ckp_livro ADD CONSTRAINT un_ckp_livro_titulo UNIQUE (nm_titulo);

/*2.10 Na tabela “T_CKP_AUTOR_LIVRO”, crie a instrução SQL, comando
DDL para eliminar a constraint chave estrangeira
“FK_CKP_AUTOR_LIVRO_AUTOR”.*/
ALTER TABLE t_ckp_autor_livro DROP CONSTRAINT fk_ckp_autor_livro_autor;

/*2.11 Na tabela “T_CKP_LIVRO”, crie a instrução SQL, comando DDL
para eliminar a constraint chave primária “PK_CKP_LIVRO”, com a opção
“CASCADE”, que elimina o relacionamento existente.*/
ALTER TABLE t_ckp_livro DROP CONSTRAINT pk_ckp_livro CASCADE;

/*2.12 Na tabela “T_CKP_CATEGORIA”, crie a instrução SQL, comando
DDL para desabilitar a constraint UNIQUE “UN_CKP_CATEGORIA_SIGLA”
associada a coluna “ds_sigla_categ”.*/
ALTER TABLE t_ckp_categoria DISABLE CONSTRAINT un_ckp_categoria_sigla;