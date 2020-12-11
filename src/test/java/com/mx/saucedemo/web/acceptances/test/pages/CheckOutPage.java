package com.mx.saucedemo.web.acceptances.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CheckOutPage {

    private static final Logger log = Logger.getLogger(CheckOutPage.class.getName());

    /**
     * Identificación de Elementos Web.
     */
    @FindBy(how = How.ID, using = "first-name")
    private SelenideElement txtFirstName;

    @FindBy(how = How.ID, using = "last-name")
    private SelenideElement txtLastName;

    @FindBy(how = How.ID, using = "postal-code")
    private SelenideElement txtPostalCode;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")
    private SelenideElement btnContinue;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout_info_container\"]/div/form/h3")
    private SelenideElement mssgError;


    public CheckOutPage() {
        try {
            $(By.id("first-name")).waitUntil(Condition.exist, 60000);
            log.info("La página checkout se abrió correctamente");
        }catch (Exception e) {
            log.info("SE PRESENTO UN ERROR AL ABRIR EL CHECKOUT: " + e.toString());
        }
    }

    /**
     * Metodos para obtener elementos Web del Dashboard
     */

    public SelenideElement getTxtLastName() {
        return txtLastName;
    }

    public SelenideElement getTxtFirstName() {
        return txtFirstName;
    }

    public SelenideElement getTxtPostalCode() {
        return txtPostalCode;
    }

    public SelenideElement getBtnContinue() {
        return btnContinue;
    }

    public SelenideElement getMssgError(){ return mssgError; }

    public boolean validateCheckOut() {
        if(txtFirstName.isEnabled()) {
            log.info("Existen los elementos para iniciar la Prueba del checkout");
            return true;
        }else {
            log.info("No existen los elementos para iniciar la Prueba");
            return false;
        }
    }

    public void continueWithFailParams() throws InterruptedException {
        getTxtFirstName().sendKeys("Mauricio");
        getTxtLastName().sendKeys("Mondragon");
        getBtnContinue().click();
        Thread.sleep(2500);
    }

    public boolean validateError(){
        return getMssgError().getText().equals("Error: Postal Code is required");
    }

    public FinishPage toFinishPage() throws InterruptedException {
        getTxtPostalCode().sendKeys("06400");
        Thread.sleep(1500);
        getBtnContinue().click();
        return page(FinishPage.class);
    }

}
