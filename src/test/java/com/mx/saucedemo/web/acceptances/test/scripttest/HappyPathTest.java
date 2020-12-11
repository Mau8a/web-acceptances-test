package com.mx.saucedemo.web.acceptances.test.scripttest;

import com.mx.saucedemo.web.acceptances.test.pages.*;
import org.junit.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Logger;

public class HappyPathTest {

private static final Logger log = Logger.getLogger(HappyPathTest.class.getName());
	
	private LoginPage loginPage;

	
	/**
	 * Before ambientación de PageLogin.
	 */
	
	@Before
	public void setUpPage(){
		try {
			loginPage = Selenide.open(Configuration.baseUrl, LoginPage.class);
		} catch (Exception e) {
			log.info("SE PRESENTO UN ERROR AL INICIAR LA PRUEBA: " + e.toString());
		}
	}
	
	
	/**
	 * Happy path acceso a Web.
	 */
	
	@Test
	public void happyPath() {	
	
		try {
			log.info(" --------------     HAPPY PATH: Acceder al Sistema con datos validos y Realizar Pedido    --------------------- ");

			if(loginPage.validaElementosInicioTest()) {
				log.info(" INGRESO DE DATOS LOGIN ");
				MainDashboard mainDashboard = loginPage.toMainDashboard();
				if(mainDashboard.validaDashboard()) {
					mainDashboard.addToCart();
					CartPage cartPage = mainDashboard.toCartPage();
					if(cartPage.validateCart()){
						cartPage.assertProducts();
						cartPage.removeLastProduct();
						CheckOutPage checkOutPage = cartPage.toCheckoutProducts();
						if(checkOutPage.validateCheckOut()){
							checkOutPage.continueWithFailParams();
							if (checkOutPage.validateError()){
								FinishPage finishPage = checkOutPage.toFinishPage();
								if(finishPage.validateFinishPage()){
									LastPage lastPage = finishPage.toLastPage();
									if(lastPage.validateOrderPage()){
										lastPage.assertOrderText();
									}else{
										log.info("NO SE REALIZO CORRECTAMENTE LA VALIDACION DE LA ORDEN FINAL");
										Assert.fail();
									}
								}else{
									log.info("NO SE REALIZO CORRECTAMENTE LA VALIDACION DE LA PAGINA FINAL");
									Assert.fail();
								}
							}else{
								log.info("NO SE REALIZO PASO A ULTIMA PAGINA CORRECTAMENTE");
								Assert.fail();
							}
						}else{
							log.info("NO SE REALIZO CORRECTAMENTE LA VALIDACION CHECKOUT PARAMETROS INCORRECTOS");
							Assert.fail();
						}
					}else{
						log.info("NO SE REALIZO CHECKOUT CORRECTAMENTE");
						Assert.fail();
					}
				}else {
					log.info("NO SE REALIZO LOGIN CORRECTAMENTE");
					Assert.fail();
				}
			}else {
				log.info("LA VALIDACION DE ELEMENTOS RETORNO FALSE");
			}
			log.info(" --------------   FIN HAPPY PATH  --------------------- ");
		} catch (Exception e) {
			log.info("SE PRESENTO UN PROBLEMA AL INICIAR LA PRUEBA: " + e.getMessage());
		}
	}
}
