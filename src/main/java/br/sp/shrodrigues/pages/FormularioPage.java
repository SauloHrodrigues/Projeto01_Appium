package br.sp.shrodrigues.pages;

import br.sp.shrodrigues.core.CellInteraction;
import io.appium.java_client.MobileBy;

public class FormularioPage {

	private CellInteraction interaction;
		
	public FormularioPage(CellInteraction interaction) {
		this.interaction = interaction;
	}

//	clicar
	
	public void clicarCheck() {
		interaction.clickElement(MobileBy.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		interaction.clickElement(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarSalvar() {
		interaction.clickElement(MobileBy.className("android.widget.Button"));
	}


	public void escreverNome(String nome ) {
		interaction.writerCamp(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String getNomeEscrito() {
		return interaction.getContentText(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionaCombo(String opcao) {
		interaction.clickElement(MobileBy.AccessibilityId("console"));
		interaction.clickElement(MobileBy.xpath("//android.widget.CheckedTextView[@text='"+opcao+"']"));
	}
	
	public String getEelmentoSelecionadoCombo() {
		 return interaction.getContentText(MobileBy.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
		
	public boolean getStatusCheck(){
		String aux = interaction.getElement(MobileBy.className("android.widget.CheckBox")).getAttribute("checked");
		if(aux.equalsIgnoreCase("true")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean getStatusWitch(){
		String aux = interaction.getElement(MobileBy.AccessibilityId("switch")).getAttribute("checked");
		if(aux.equalsIgnoreCase("true")) {
			return true;
		}else {
			return false;
		}
	}

//	Relatório final
	
	public String getNomeCadastrado() {
		return interaction.getContentText(MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Nome')]"));
	}
	
	public String getSwitchCadastrado() {
		return interaction.getContentText(
				MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Switch:')]"));		
	}
	
	public String getCheckCadastrado() {
		return interaction.getContentText(MobileBy.xpath("//android.widget.TextView[starts-with(@text,'Checkbox:')]"));
	}
	

}