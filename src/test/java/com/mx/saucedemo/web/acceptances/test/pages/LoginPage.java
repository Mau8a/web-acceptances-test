package com.mx.saucedemo.web.acceptances.test.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


public class LoginPage {

	private static final Logger log = Logger.getLogger(LoginPage.class.getName());
	/**
	 * Identificación de Elementos Web.
	 */
	@FindBy(how = How.ID, using = "user-name")
	private SelenideElement txtInputUser;
	
	@FindBy(how = How.ID, using = "password")
	private SelenideElement txtInputPassword;
	
	@FindBy(how = How.ID, using = "login-button")
	private SelenideElement btnLogIn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"inventory_filter_container\"]/div")
	private SelenideElement products;

	
	
	/**
	 * Constructor Loginpage.
	 */
	public LoginPage() {
		try {
			$(By.id("user-name")).waitUntil(Condition.visible, 600000);
			log.info("La página saucedemo abrió correctamente");
		} catch (Exception e) {
			log.info("Se presentó un error en el Constructor de Login: " + e.getMessage());
		}
		
	}

	
	/**
	 * Metodos para obtener elementos Web de LoginPage
	 */
	public SelenideElement getUserInput() {

		return txtInputUser;
	}
	
	public SelenideElement getPasswordInput() {

		return txtInputPassword;
	}
	
	public SelenideElement getBotonEnviar() {

		return btnLogIn;
	}

	
	
	public MainDashboard toMainDashboard() {
		getUserInput().sendKeys("standard_user");
		getPasswordInput().sendKeys("secret_sauce");
		getBotonEnviar().click();
		return page(MainDashboard.class);
	}
	
	public boolean validaElementosInicioTest() {
		if(txtInputUser.isEnabled()) {
			log.info("Existen los elementos para iniciar la Prueba");
			return true;
		}else {
			log.info("No existen los elementos para iniciar la Prueba");
			return false;
		}
	}

}
