package br.sp.shrodrigues.pages;

import org.openqa.selenium.By;

import br.sp.shrodrigues.core.CellInteraction;

public class MenuPage {
	private CellInteraction interaction;
	
	public MenuPage(CellInteraction interaction) {
		this.interaction = interaction;
	}
	
	public void clicarFormulario() {
		interaction.clickElement(By.xpath("//*[@text='Formulário']"));
	}
}
