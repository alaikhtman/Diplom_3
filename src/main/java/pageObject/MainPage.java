package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }



    //Button "zum Antrag"
    private By applyButton = By.xpath(".//a[@href ='https://finanzen.check24.de/accounts/d/daf-entry/creditcard?productNames=norwegian-visa-resumable&BANK_PRODUCT_ID=501880&cpid=checkbank&wpset=default&b2bid=50&deviceoutput=desktop']");



    //Button accept cookie info "Geht klar"
    private By okButton = By.xpath(".//*[text()='Geht klar']");


    @Step("Accept cookies info")
    public void acceptCookieInfo() {
        assertTrue(driver.findElement(okButton).isEnabled());
        driver.findElement(okButton).click();
    }


    @Step("Click button 'zum Antrag'")
    public void clickApplyButton() {
        driver.findElement(applyButton).click();
    }



    //Load Main Page
    public void waitMainPage() {
        new WebDriverWait(driver, 20 )
                .until(ExpectedConditions.visibilityOfElementLocated(applyButton));

    }

    //Check cookies
    @Step("Check cookies for main page")
    public void checkCookies(String cookieName) {
        Cookie cookie = driver.manage().getCookieNamed("ppset");
        assertEquals(cookieName, cookie.getValue());
  }





}
