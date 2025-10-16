CREATE SEQUENCE SEQ_RHSTU_ESTADO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO t_rhstu_estado (id_estado, sg_estado, nm_estado)
values(seq_rhstu_estado.nextval, 'SP', 'São Paulo');

CREATE SEQUENCE SEQ_RHSTU_CIDADE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO t_rhstu_cidade (id_cidade, id_estado, nm_cidade, cd_ibge, nr_ddd)
values(seq_rhstu_cidade.nextval, 1, 'Suzano', 1, 11);

CREATE SEQUENCE SEQ_RHSTU_BAIRRO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO t_rhstu_bairro (id_bairro, id_cidade, nm_bairro, nm_zona_bairro)
values(seq_rhstu_bairro.nextval, 1, 'Casa Branca','ZONA SUL');


CREATE SEQUENCE SEQ_RHSTU_LOGRADOURO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO t_rhstu_logradouro (id_logradouro,id_bairro, nm_logradouro, nr_cep)
values(seq_rhstu_logradouro.nextval, 1, 'Rua Ângelo Crepaldi',08663340);

CREATE SEQUENCE SEQ_RHSTU_PACIENTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO t_rhstu_paciente (id_paciente, nm_paciente, nr_cpf, nm_rg, dt_nascimento, fl_sexo_biologico, ds_escolaridade, ds_estado_civil, nm_grupo_sanguineo, nr_altura, nr_peso)
values(seq_rhstu_paciente.nextval,'Gabriel Nogueira Peixoto', '11122233344','1122233344', TO_DATE('07/06/2002', 'DD/MM/YYYY'), 'M','SUPERIOR COMPLETO', 'CASADO', 'AB+', 1.82, 100);

CREATE SEQUENCE SEQ_RHSTU_ENDERECO_PACIENTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO t_rhstu_endereco_paciente (id_endereco, id_paciente, id_logradouro, nr_logradouro, ds_complemento_numero, ds_ponto_referencia, dt_inicio, dt_fim)
values(seq_rhstu_endereco_paciente.nextval,1, 1,188, NULL, NULL, SYSDATE,NULL);


CREATE SEQUENCE SEQ_RHSTU_TIPO_CONTATO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
INSERT INTO T_RHSTU_TIPO_CONTATO (ID_TIPO_CONTATO, NM_TIPO_CONTATO,DT_INICIO,DT_FIM)
VALUES  (SEQ_RHSTU_TIPO_CONTATO.nextval,'MÃE', sysdate ,null);

CREATE SEQUENCE SEQ_RHSTU_CONTATO_PACIENTE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO T_RHSTU_CONTATO_PACIENTE (ID_PACIENTE, ID_CONTATO, ID_TIPO_CONTATO, NM_CONTATO, NR_DDI, NR_DDD, NR_TELEFONE)
VALUES (1,SEQ_RHSTU_CONTATO_PACIENTE.nextval,1,'Maria Peixoto', 55, 11, 955890424);


CREATE SEQUENCE SEQ_RHSTU_UNID_HOSPITALAR
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO T_RHSTU_UNID_HOSPITALAR (ID_UNID_HOSPITAL, ID_LOGRADOURO, NM_UNID_HOSPITALAR, NM_RAZAO_SOCIAL_UNID_HOSP,DT_FUNDACAO,NR_LOGRADOURO,DS_COMPLEMENTO_NUMERO,DS_PONTO_REFERENCIA,DT_INICIO,DT_TERMINO)
VALUES (SEQ_RHSTU_UNID_HOSPITALAR.nextval, 1, 'Hospital Ipiranga', 'Hospital Ipiranga Razões Médicas',TO_DATE ('10/10/1955', 'DD/MM/YYYY'), 1500, null, null, SYSDATE,null);


CREATE SEQUENCE SEQ_RHSTU_MEDICO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO T_RHSTU_MEDICO (CD_MEDICO, NM_MEDICO, NR_CRM, DS_ESPECIALIDADE)
VALUES(SEQ_RHSTU_MEDICO.nextval,'Maria Eduarda Lima',3456789,'Infectologista');


CREATE SEQUENCE SEQ_RHSTU_CONSULTA
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
INSERT INTO T_RHSTU_CONSULTA (id_unid_hospital,nr_consulta,id_paciente,cd_medico,dt_hr_consulta,nr_consultorio)
VALUES  (1,seq_rhstu_consulta.nextval,1,1,TO_DATE ('25/10/2025', 'DD/MM/YYYY'),4);


CREATE SEQUENCE SEQ_RHSTU_PLANO_SAUDE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

INSERT INTO T_RHSTU_PLANO_SAUDE (ID_PLANO_SAUDE, DS_RAZAO_SOCIAL, NM_FANTASIA_PLANO_SAUDE,DS_PLANO_SAUDE,NR_CNPJ,NM_CONTATO,DS_TELEFONE,DT_INICIO,DT_FIM)
VALUES (seq_rhstu_plano_saude.nextval, 'Plano Zen Planos Médicos LTDA', 'Plano Zen', 'O Plano Zen foi feito para aqueles que querem ter um contato maiz zen para suas consultas', 82414549000197, 'Maria Joana','11955983690',SYSDATE,null);


CREATE SEQUENCE SEQ_RHSTU_PACIENTE_PLANO_SAUDE
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
insert into T_RHSTU_PACIENTE_PLANO_SAUDE (id_paciente_ps, id_paciente, id_plano_saude, nr_carteira_ps, dt_inicio, dt_fim) values
(SEQ_RHSTU_PACIENTE_PLANO_SAUDE.nextval, 1, 1, null, sysdate, null);


CREATE SEQUENCE SEQ_RHSTU_forma_pagamento
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
insert into t_rhstu_forma_pagamento (id_forma_pagto, nm_forma_pagto, ds_forma_pagto, st_forma_pagto)
values 
(SEQ_RHSTU_forma_pagamento.nextval, 'Plano de Saúde' ,'pagamento feito através de reembolso do plano', 'A');
    
insert into t_rhstu_forma_pagamento (id_forma_pagto, nm_forma_pagto, ds_forma_pagto, st_forma_pagto)
values 
(SEQ_RHSTU_forma_pagamento.nextval, 'Cartão de Crédito', 'Pagamento feito através de cartão de credito', 'A');



CREATE SEQUENCE SEQ_RHSTU_CONSULTA_FORMA_PAGTO
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

insert into t_rhstu_consulta_forma_pagto (id_consulta_forma_pagto, id_unid_hospital , nr_consulta , id_paciente_ps, id_forma_pagto, dt_cadastro, dt_pagto_consulta, st_pagto_consulta) values
(SEQ_RHSTU_CONSULTA_FORMA_PAGTO.nextval, 1, 1, 1, 2, SYSDATE, null, 'P');

COMMIT;


UPDATE T_RHSTU_FORMA_PAGAMENTO SET ST_FORMA_PAGTO = 'I' WHERE ID_FORMA_PAGTO = 2;
UPDATE T_RHSTU_TIPO_CONTATO SET DT_FIM = TO_DATE('15/05/2025', 'DD/MM/YYYY') WHERE ID_TIPO_CONTATO = 1;


DELETE FROM T_RHSTU_PACIENTE WHERE ID_PACIENTE = 1;
-- Pergunta 1:
-- R: Não foi possível excluir o paciente. A exclusão não pode acontecer porque o paciente 1 é referenciado em outras tabelas filhas como a de endereço, plano de saúde ou contato.
-- Para fazer a essa exclusão de maneira segura, deveriamos começar pelas tabelas independentes que tem o paciente como chave estrangeira para depois deletar a tabela pai.

DELETE FROM T_RHSTU_FORMA_PAGAMENTO WHERE ID_FORMA_PAGTO = 2;
-- Pergunta 2:
-- R: Não foi possível excluir a forma de pagamento. A exclusão não pode acontecer pelo mesmo motivo da resposta acima, a forma de pagamento de código 2 é utilizada na tabela
-- T_RHSTU_CONSULTA_FORMA_PAGTO, que é a tabela responsável para armazenar a forma de pagamento de uma consulta específica, logo precisamos desvincular esse código 
-- que está sendo utilizado como fk para poder fazer a exclusão corretamente.
    
commit;


