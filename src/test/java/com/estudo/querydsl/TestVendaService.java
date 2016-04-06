package com.estudo.querydsl;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.estudo.querydsl.domain.Cliente;
import com.estudo.querydsl.domain.Venda;
import com.estudo.querydsl.domain.VendaProduto;
import com.estudo.querydsl.service.VendaService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:application-context-persistence.xml"})
@Transactional
public class TestVendaService{
	
	@Autowired
    private ApplicationContext context;
    		 
	@Before
	public void setUp() throws Exception {
		new EmbeddedDatabaseBuilder()
			.setType(EmbeddedDatabaseType.H2)
			.build();
	}
	
	@Test
	public void testFindClienteByNomeHQL() {
		VendaService vendaService = (VendaService)context.getBean("vendaServiceImpl");		
		List<VendaProduto> list = vendaService.findVendaByFiltros("Joao", null, null);
		
		List<Venda> vendas = list.stream().map(v -> v.getVenda()).distinct().collect(Collectors.toList());		
		MatcherAssert.assertThat(vendas, Matchers.hasItem(Matchers.hasProperty("id", Matchers.equalTo(1))));
		List<Cliente> clientes = vendas.stream().map(v -> v.getCliente()).distinct().collect(Collectors.toList());
		MatcherAssert.assertThat(clientes, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Joao"))));
		
	}
}
