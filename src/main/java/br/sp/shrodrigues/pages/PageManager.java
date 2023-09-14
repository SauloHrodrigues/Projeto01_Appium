package br.sp.shrodrigues.pages;

import br.sp.shrodrigues.core.CellInteraction;

public class PageManager {

	private FormularioPage formulario;
	private MenuPage menu;
	private CellInteraction interaction;
	

	public PageManager() {
		this.interaction = new CellInteraction();
	}

	public FormularioPage formulario() {
		
		if(formulario == null) {
			formulario = new FormularioPage(interaction);
		}
		return formulario;
	}

	public MenuPage menu() {
		
		if(menu == null) {
			menu = new MenuPage(interaction);
		}
		return menu;
	}
}
