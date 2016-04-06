package com.estudo.querydsl.repository;

import java.util.Date;
import java.util.List;

import com.estudo.querydsl.domain.VendaProduto;

public interface VendaServiceRepository {

	List<VendaProduto> findVendaByFiltros(String cliente, String produto, Date lancamento);

}
