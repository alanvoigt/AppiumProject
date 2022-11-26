package test.alan;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("appium:deviceName", "emulator");
		    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		   // desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Alan/Repositories/Appium/test/src/test/resources/CTAppium_1_2.apk");

		    
		    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //selecionar formulario
		    List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		    for(MobileElement elemento: elementosEncontrados) {
		    	System.out.println(elemento.getText());
		    }
		    elementosEncontrados.get(1).click();
		    
		    // escrever nome
		    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		    campoNome.sendKeys("Alan");
		    
		    // checar nome escrito
		    String text = campoNome.getText();
		    Assert.assertEquals("Alan", text);
		    
		    driver.quit();
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("appium:deviceName", "emulator");
		    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		   // desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Alan/Repositories/Appium/test/src/test/resources/CTAppium_1_2.apk");

		    
		    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //selecionar formulario
		    driver.findElement(By.xpath("//android.widget.TextView[@text='Formul�rio']")).click();
		    
		    // clicar no combo
		    driver.findElement(MobileBy.AccessibilityId("console")).click();
		    
		    // selecionar a op��o
		    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		    
		    // verificar a op��o selecionada
		    String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		    Assert.assertEquals("Nintendo Switch", text);
		    
		    driver.quit();
	}
	
	@Test
	public void deveInteragirSwitchCheckbox() throws MalformedURLException {
		 DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("appium:deviceName", "emulator");
		    desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
		   // desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Alan/Repositories/Appium/test/src/test/resources/CTAppium_1_2.apk");

		    
		    AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    
		    //selecionar formulario (qualquer elemento que tenha o texto formul�rio)
		    driver.findElement(By.xpath("//*[@text='Formul�rio']")).click();
		    
		    // Verificar status dos elementos
		    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		    MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		    Assert.assertTrue(check.getAttribute("checked").equals("false")); //true or false (n�o � boolean. � string)
		    Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		    
		    // clicar nos elementos
		    check.click();
		    switc.click();
		    
		    // verificar estados alterados
		    Assert.assertTrue(check.getAttribute("checked").equals("true")); //true or false (n�o � boolean. � string)
		    Assert.assertTrue(switc.getAttribute("checked").equals("false"));
		    
		    
		    driver.quit();
	}
}
