package com.mx.saucedemo.web.acceptances.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.logging.Logger;
import static com.codeborne.selenide.Selenide.$;

public class LastPage {

    private static final Logger log = Logger.getLogger(LastPage.class.getName());

    /**
     * Identificación de Elementos Web.
     */

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout_complete_container\"]/h2")
    private SelenideElement txtOrder;


    public LastPage() {
        try {
            $("//*[@id=\"checkout_complete_container\"]/h2").waitUntil(Condition.exist, 60000);
            log.info("La página confirmación de orden se abrió correctamente");
        }catch (Exception e) {
            log.info("SE PRESENTO UN ERROR AL ABRIR EL CHECKOUT: " + e.toString());
        }
    }

    /**
     * Metodos para obtener elementos Web del Dashboard
     */

    public SelenideElement getTxtOrder() {
        return txtOrder;
    }


    public boolean validateOrderPage() {
        if(txtOrder.isDisplayed()) {
            log.info("Existen los elementos para iniciar la Prueba final");
            return true;
        }else {
            log.info("No existen los elementos para iniciar la Prueba");
            return false;
        }
    }

    public void assertOrderText() throws InterruptedException {
        Thread.sleep(2500);
        assert (getTxtOrder().getText().equals("THANK YOU FOR YOUR ORDER"));
        Thread.sleep(1500);
    }
}
