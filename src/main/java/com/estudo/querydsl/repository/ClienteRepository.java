package com.estudo.querydsl.repository;

import java.util.List;

import com.estudo.querydsl.domain.Cliente;

public interface ClienteRepository {

	List<Cliente> findByNomeHQL(String nome);

	List<Cliente> findByNomeQueryDSL(String nome);

	List<Cliente> findByNomeCpfTelefoneHQL(String nome, String cpf, String telefone);

	List<Cliente> findByNomeCpfTelefoneQueryDSL(String nome, String cpf, String telefone);

	void delete(Integer id);

	void update(Integer id, String nome);

}
