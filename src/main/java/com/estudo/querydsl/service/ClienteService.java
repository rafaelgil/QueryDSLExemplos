package com.estudo.querydsl.service;

import java.util.List;

import com.estudo.querydsl.domain.Cliente;

public interface ClienteService {
	
	List<Cliente> findByNomeHQL(String nome);
	List<Cliente> findByNomeQueryDSL(String nome);
	List<Cliente> findByNomeCpfTelefoneHQL(String nome, String cpf, String telefone);
	List<Cliente> findByNomeCpfTelefoneQueryDSL(String nome, String cpf, String telefone);

}
