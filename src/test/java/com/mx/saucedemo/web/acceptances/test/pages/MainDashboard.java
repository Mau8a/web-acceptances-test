package com.mx.saucedemo.web.acceptances.test.pages;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class MainDashboard {
	
	
	private static final Logger log = Logger.getLogger(MainDashboard.class.getName());
	
	/**
	 * Identificación de Elementos Web.
	 */
	@FindBy(how = How.ID, using = "header-container")
	private SelenideElement labelSwagLabs;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button")
	private SelenideElement bckPckAddCart;

	@FindBy(how = How.XPATH, using = "//*[@id=\"inventory_container\"]/div/div[4]/div[3]/button")
	private SelenideElement fleeJacketAddCart;

	@FindBy(how = How.XPATH, using = "//*[@id=\"shopping_cart_container\"]/a")
	private SelenideElement cart;


	public MainDashboard() {
		try {
			$(By.id("inventory_container")).waitUntil(Condition.exist, 60000);
			log.info("El Dashboard se abrió correctamente");
		}catch (Exception e) {
			log.info("SE PRESENTO UN ERROR AL ABRIR EL DASHBOARD: " + e.toString());
		}	
	}
	
	/**
	 * Metodos para obtener elementos Web del Dashboard
	 */
	
	public SelenideElement getBackPackCart() {
		return bckPckAddCart;
	}
	
	public SelenideElement getMainLabel() {
		return labelSwagLabs;
	}
	
	public SelenideElement getFleeJacketAddCart() {
		return fleeJacketAddCart;
	}

	public SelenideElement getCart() {
		return cart;
	}
	

	
	public boolean validaDashboard() {
		if(bckPckAddCart.isEnabled()) {
			log.info("Existen los elementos para iniciar la Prueba añadir al carrito");
			return true;
		}else {
			log.info("No existen los elementos para iniciar la Prueba");
			return false;
		}
	}

	public void addToCart() {
		$(By.id("inventory_container")).waitUntil(Condition.exist, 10000);
		getBackPackCart().click();
		getFleeJacketAddCart().click();
	}

	public CartPage toCartPage(){
		getCart().click();
		return page(CartPage.class);
	}
	
	
}
