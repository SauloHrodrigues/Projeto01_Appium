package br.sp.shrodrigues.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.sp.shrodrigues.core.DriverFactory;
import br.sp.shrodrigues.pages.PageManager;

public class FormularioTests {
	
	private PageManager page = new PageManager();
	
	@Before
	public void inicializar() {
		page.menu().clicarFormulario();
		
	}
	
	
	@After
	public void finaliza() {
		DriverFactory.killDriver();
	}

	
	@Test
	public void devePreencherCampoTexto() {
		page.formulario().escreverNome("Saulo");
		Assert.assertEquals("Saulo", page.formulario().getNomeEscrito());
	}

	
	@Test
	public void deveInteragirComCombo() {
		page.formulario().selecionaCombo("PS4");
		Assert.assertEquals("PS4", page.formulario().getEelmentoSelecionadoCombo());		
	}

	
	@Test
	public void deveInteragirSwitchCheckBox() {
	
		Assert.assertFalse(page.formulario().getStatusCheck());
		Assert.assertTrue(page.formulario().getStatusWitch());

		page.formulario().clicarCheck();
		page.formulario().clicarSwitch();

		Assert.assertTrue(page.formulario().getStatusCheck());
		Assert.assertFalse(page.formulario().getStatusWitch());
	}

	
	@Test
	public void primeiroDesafio_deveValidarDadosSalvos() {
		
		page.formulario().escreverNome("Saulo Henrique");
		page.formulario().selecionaCombo("Nintendo Switch");
		page.formulario().clicarCheck();
		page.formulario().clicarSwitch();
		page.formulario().clicarSalvar();

		Assert.assertTrue(page.formulario().getNomeCadastrado().contains("Saulo Henrique"));
		Assert.assertTrue(page.formulario().getSwitchCadastrado().endsWith("Off"));
		Assert.assertEquals("Checkbox: Marcado", page.formulario().getCheckCadastrado());		
	}
}