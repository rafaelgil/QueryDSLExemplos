package com.estudo.querydsl;


import java.util.List;

import javax.transaction.Transactional;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.estudo.querydsl.configuration.ApplicationConfiguration;
import com.estudo.querydsl.domain.Cliente;
import com.estudo.querydsl.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(classes=ApplicationConfiguration.class)
@Transactional
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class TestClienteService{
	
	@Autowired
    private ApplicationContext context;
	
	@Test
	public void testFindClienteByNomeHQL() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeHQL("Pedro");
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Pedro"))));		
		
	}
	
	@Test
	public void testFindClienteByNomeQueryDSL() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeQueryDSL("Pedro");
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Pedro"))));		
		
	}
	
	@Test
	public void testFindByNomeCpfTelefoneHQL() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneHQL("Ana", null, null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Ana Maria"))));		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Ana"))));
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Pedro")))));
		
	}
	
	@Test
	public void testFindByNomeCpfTelefoneQueryDSL() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneQueryDSL("Ana", null, null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Ana Maria"))));		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Ana"))));
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Pedro")))));
		
	}
	
	@Test
	public void testFindByNomeCpfTelefoneHQLSomenteNomeCpfInformados() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneHQL("Ana", "88784842258", null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Ana"))));
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Ana Maria")))));				
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Pedro")))));
		
	}
	
	@Test
	public void testFindByNomeCpfTelefoneQueryDSLSomeNomeCpfInformados() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneQueryDSL("Ana", "88784842258", null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Ana"))));
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Ana Maria")))));				
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Pedro")))));
		
	}
	
	@Test
	public void testFindByNomeCpfTelefoneHQLSomenteCpfInformado() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneHQL(null, "88478954715", null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Joao"))));
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Ana Maria")))));				
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Pedro")))));
		
	}
	
	@Test
	public void testFindByNomeCpfTelefoneQueryDSLSomenteCpfInformado() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneQueryDSL(null, "88478954715", null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Joao"))));
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Ana Maria")))));				
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.not(Matchers.equalTo("Pedro")))));
		
	}
	
	@Test
	public void testDelete() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");
		
		clienteService.delete(2);
		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneQueryDSL(null, "87412547154", null);
		
		MatcherAssert.assertThat(list, Matchers.empty());		
		
	}
	
	@Test
	public void testUpdate() {
		ClienteService clienteService = (ClienteService)context.getBean("clienteServiceImpl");
		
		clienteService.update(3, "Pedro Update");
		
		List<Cliente> list = clienteService.findByNomeCpfTelefoneQueryDSL(null, "84848487877", null);
		
		MatcherAssert.assertThat(list, Matchers.hasItem(Matchers.hasProperty("nome", Matchers.equalTo("Pedro Update"))));	
		
	}
				
	
}
