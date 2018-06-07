/* ========================= SELECT*/
/* ==============================================================*/
select count(*) as 'QUANTIDADE DE PROCESSOS' 
from processo;

select Autor as 'AUTOR', NumeroProcesso as 'NÚMERO DO PROCESSO', Vara as 'VARA' 
from Processo order by Autor;

select Autor as 'AUTOR', NumeroProcesso as 'NÚMERO DO PROCESSO', Vara as 'VARA' 
from processo where autor like '%?%';

Select Vara as 'VARA', Autor as 'AUTOR', NumeroProcesso as 'NÚMERO DO PROCESSO' 
from Processo where Vara like '%?%';

select autor, numeroProcesso, vara from processo;

-- [0-9]{7}-[0-9]{2}.[0-9]{4}.[0-9].[0-9]{2}.[0-9]{4}
-- [0-9]{4}.[0-9]{3}.[0-9]{6}-[0-9]
select autor, numeroProcesso, vara 
from processo 
where numeroProcesso regexp '[0-9]{4}.[0-9]{3}.[0-9]{6}-[0-9]';

/* ========================= PROCEDURE*/
/* ==============================================================*/
-- procedure em q seleciona o autor, numero e vara ordenado por autor e modifica sua chave primaria colocando de 1 ate o ultimo, na ordem dos autores
