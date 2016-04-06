package com.estudo.querydsl.repository;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.estudo.querydsl.domain.Cliente;
import com.estudo.querydsl.domain.QCliente;
import com.estudo.querydsl.utils.WhereBooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Cliente> findByNomeHQL(String nome) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select c from Cliente as c ");
		sql.append(" where 1=1 ");
		if(Objects.nonNull(nome)){
			sql.append(" and c.nome like :nome ");
		}
		
		Query query = entityManager.createQuery(sql.toString());
		
		if(Objects.nonNull(nome)){
			query.setParameter("nome","%"+nome+"%");
		}
		
		List<Cliente> lista = query.getResultList();
		
		return lista;	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> findByNomeQueryDSL(String nome) {
		
		QCliente cliente = QCliente.cliente;
		JPAQuery<Cliente> query = new JPAQuery<Cliente>(entityManager);		
		List<Cliente> resultList = query.from(cliente)
				.where(
					new WhereBooleanBuilder()
						.optionalAnd(nome, ()-> cliente.nome.like(nome))						
				)
				.createQuery().getResultList();
		
		return resultList;
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> findByNomeCpfTelefoneHQL(String nome, String cpf, String telefone) {
		StringBuilder sql = new StringBuilder();
		sql.append("select c from Cliente as c ");
		sql.append(" where 1=1 ");
		if(Objects.nonNull(nome)){
			sql.append(" and c.nome like :nome ");
		}
		if(Objects.nonNull(cpf)){
			sql.append(" and c.cpf = :cpf ");
		}
		if(Objects.nonNull(telefone)){
			sql.append(" and c.telefone = :telefone ");
		}
		
		Query query = entityManager.createQuery(sql.toString());
		
		if(Objects.nonNull(nome)){
			query.setParameter("nome","%"+nome+"%");
		}
		if(Objects.nonNull(cpf)){
			query.setParameter("cpf", cpf);
		}
		if(Objects.nonNull(telefone)){
			query.setParameter("telefone", telefone);
		}
		
		List<Cliente> lista = query.getResultList();
		
		return lista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Cliente> findByNomeCpfTelefoneQueryDSL(String nome, String cpf, String telefone) {
		
		QCliente cliente = QCliente.cliente;
		JPAQuery<Cliente> query = new JPAQuery<Cliente>(entityManager);		
		List<Cliente> resultList = query.from(cliente)
				.where(
					new WhereBooleanBuilder()
						.optionalAnd(nome, ()-> cliente.nome.like("%"+nome+"%"))						
						.optionalAnd(cpf, ()-> cliente.cpf.eq(cpf))
						.optionalAnd(telefone, ()-> cliente.telefone.eq(telefone))
				)
				.createQuery().getResultList();
		
		return resultList;
		
	}

}
