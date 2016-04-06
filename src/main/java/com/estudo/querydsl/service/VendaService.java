package com.estudo.querydsl.service;

import java.util.Date;
import java.util.List;

import com.estudo.querydsl.domain.VendaProduto;

public interface VendaService {
	
	List<VendaProduto> findVendaByFiltros(String cliente, String produto, Date lancamento);

}
