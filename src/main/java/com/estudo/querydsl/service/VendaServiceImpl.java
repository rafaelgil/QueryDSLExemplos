package com.estudo.querydsl.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.querydsl.domain.VendaProduto;
import com.estudo.querydsl.repository.VendaServiceRepository;

@Transactional
@Service
public class VendaServiceImpl implements VendaService{

	@Autowired
	private VendaServiceRepository vendaServiceRepository;
	
	@Override
	public List<VendaProduto> findVendaByFiltros(String cliente, String produto, Date lancamento) {
		return vendaServiceRepository.findVendaByFiltros(cliente, produto, lancamento);
	}

}
