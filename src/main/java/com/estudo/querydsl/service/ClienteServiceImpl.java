package com.estudo.querydsl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estudo.querydsl.domain.Cliente;
import com.estudo.querydsl.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findByNomeHQL(String nome) {		
		return clienteRepository.findByNomeHQL(nome);
	}

	@Override
	public List<Cliente> findByNomeQueryDSL(String nome) {
		return clienteRepository.findByNomeQueryDSL(nome);
	}

	@Override
	public List<Cliente> findByNomeCpfTelefoneHQL(String nome, String cpf, String telefone) {
		return clienteRepository.findByNomeCpfTelefoneHQL(nome, cpf, telefone);
	}

	@Override
	public List<Cliente> findByNomeCpfTelefoneQueryDSL(String nome, String cpf, String telefone) {
		return clienteRepository.findByNomeCpfTelefoneQueryDSL(nome, cpf, telefone);
	}

}
