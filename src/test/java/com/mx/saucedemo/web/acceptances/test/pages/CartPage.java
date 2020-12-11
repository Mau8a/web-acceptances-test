package com.mx.saucedemo.web.acceptances.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CartPage {

    private static final Logger log = Logger.getLogger(CartPage.class.getName());

    /**
     * Identificación de Elementos Web.
     */
    @FindBy(how = How.XPATH, using = "//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/button")
    private SelenideElement rmvLastProduct;

    @FindBy(how = How.XPATH, using = "//*[@id=\"item_4_title_link\"]/div")
    private SelenideElement bckPckInCart;

    @FindBy(how = How.XPATH, using = "//*[@id=\"item_5_title_link\"]/div")
    private SelenideElement fleeJacketInCart;

    @FindBy(how = How.XPATH, using = "//*[@id=\"contents_wrapper\"]/div[2]")
    private SelenideElement yourCart;

    @FindBy(how = How.XPATH, using = "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
    private SelenideElement btnCheckout;


    public CartPage() {
        try {
            $(By.id("contents_wrapper")).waitUntil(Condition.exist, 60000);
            log.info("El carrito se abrió correctamente");
        }catch (Exception e) {
            log.info("SE PRESENTO UN ERROR AL ABRIR EL CARRITO: " + e.toString());
        }
    }

    /**
     * Metodos para obtener elementos Web del Dashboard
     */

    public SelenideElement getBackPackInCart() {
        return bckPckInCart;
    }

    public SelenideElement getRmvLastProduct() {
        return rmvLastProduct;
    }

    public SelenideElement getFleeJacketInCart() {
        return fleeJacketInCart;
    }

    public SelenideElement getYourCart() {
        return yourCart;
    }

    public SelenideElement getBtnCheckout(){ return btnCheckout; }

    public boolean validateCart() {
        if(getYourCart().exists()) {
            log.info("Existen los elementos para iniciar la Prueba del carrito");
            return true;
        }else {
            log.info("No existen los elementos para iniciar la Prueba");
            return false;
        }
    }

    public void assertProducts() throws InterruptedException {
        assert (getBackPackInCart().getText().equals("Sauce Labs Backpack"));
        assert (getFleeJacketInCart().getText().equals("Sauce Labs Fleece Jacket"));
        Thread.sleep(2500);
    }

    public void removeLastProduct() throws InterruptedException {
        getRmvLastProduct().click();
        assert (!getFleeJacketInCart().exists());
        Thread.sleep(1500);
    }

    public CheckOutPage toCheckoutProducts(){
        getBtnCheckout().click();
        return page(CheckOutPage.class);
    }

}
