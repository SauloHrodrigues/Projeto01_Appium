package br.sp.shrodrigues.core;

import static br.sp.shrodrigues.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class CellInteraction {

	public void writerCamp(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String getContentText(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clickElement(By by) {
		getDriver().findElement(by).click();
	}
	
	public MobileElement getElement(By by) {
		return getDriver().findElement(by);		
	}
}