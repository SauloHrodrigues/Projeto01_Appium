package br.sp.shrodrigues.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			buildDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
	private static void buildDriver(){
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("appium:deviceName", "emulator");
		desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, ""
				+ "C:\\Saulo - keego\\Keego\\Projetos\\ProjetosApppium\\CursoAppium\\src\\main\\resources\\CTAppium_2_0.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("" + "http://127.0.0.1:4723/wd/hub"),
					desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}