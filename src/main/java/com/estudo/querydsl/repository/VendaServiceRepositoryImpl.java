package com.estudo.querydsl.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.estudo.querydsl.domain.QCliente;
import com.estudo.querydsl.domain.QProduto;
import com.estudo.querydsl.domain.QVenda;
import com.estudo.querydsl.domain.QVendaProduto;
import com.estudo.querydsl.domain.VendaProduto;
import com.estudo.querydsl.utils.WhereBooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class VendaServiceRepositoryImpl implements VendaServiceRepository {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<VendaProduto> findVendaByFiltros(String nomeCliente, String descricaoProduto, Date lancamento) {
	
		QVendaProduto vendaProduto = QVendaProduto.vendaProduto;
		QVenda venda = vendaProduto.venda;
		QCliente cliente = venda.cliente;
		QProduto produto = vendaProduto.produto;
		
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		
		List<VendaProduto> resultList = queryFactory.selectFrom(vendaProduto)
				.innerJoin(venda)
				.innerJoin(produto)
				.innerJoin(cliente)
				.where(
						new WhereBooleanBuilder()
							.optionalAnd(nomeCliente, ()-> cliente.nome.like("%"+nomeCliente+"%"))						
							.optionalAnd(descricaoProduto, ()-> produto.descricao.like("%"+descricaoProduto+"%"))
							.optionalAnd(lancamento, ()-> venda.lancamento.eq(lancamento))
					)
				.createQuery()
				.getResultList();
		
		return resultList;
	}

}
