package com.mx.saucedemo.web.acceptances.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.logging.Logger;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class FinishPage {

    private static final Logger log = Logger.getLogger(FinishPage.class.getName());

    /**
     * Identificación de Elementos Web.
     */

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")
    private SelenideElement btnFinish;


    public FinishPage() {
        try {
            $("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]").waitUntil(Condition.exist, 60000);
            log.info("La página final se abrió correctamente");
        }catch (Exception e) {
            log.info("SE PRESENTO UN ERROR AL ABRIR EL CHECKOUT: " + e.toString());
        }
    }

    /**
     * Metodos para obtener elementos Web del Dashboard
     */

    public SelenideElement getBtnFinish() {
        return btnFinish;
    }


    public boolean validateFinishPage() {
        if(btnFinish.isEnabled()) {
            log.info("Existen los elementos para iniciar la Prueba final");
            return true;
        }else {
            log.info("No existen los elementos para iniciar la Prueba");
            return false;
        }
    }

    public LastPage toLastPage() throws InterruptedException {
        Thread.sleep(2500);
        btnFinish.click();
        return page(LastPage.class);
    }

}
