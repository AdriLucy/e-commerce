use dbdefendx;

select * from cliente;
select * from produto;
select * from venda;
select * from item_Venda;


/* CONSULTAR ITENS VENDIDO */
select 
	iv.id_item_venda
    ,iv.venda_id
    ,p.nome as NomeProduto
    ,p.preco
    ,iv.quantidade_produto as QtdProdutoVendido
    ,p.preco*iv.quantidade_produto as ValortotalPorItem
    
from
	item_venda iv
left join
	produto p
    on p.id_produto = iv.id_produto
where
	iv.venda_id = 1;
    
/* CONSULTAR VENDAS COM CLIENTE*/ 
select 
	v.id_venda,
    v.data as dataVenda,
    v.preco_total_venda,
    c.id_cliente,
    concat(c.nome,' ',c.sobrenome) as cliente
    ,c.email
    ,c.telefone
from
	venda v
left join
	cliente c
    on c.id_Cliente = v.id_Cliente
where
	v.id_venda = 1;


