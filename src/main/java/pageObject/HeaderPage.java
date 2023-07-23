package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка конструктора
    public By headerMainPageButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");



    //Логотип
    public By headerLogotypeButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/div/a");

    //Кнопка личного кабинета
    private By headerPrivateAreaButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/a");


    //Нажать на конструктор
    @Step("Click main page button")
    public void clickMainPage() {
        driver.findElement(headerMainPageButton).click();
    }

    //Нажатие на кнопку личного кабинета
    @Step("Click private area")
    public void clickPrivateArea() {
        driver.findElement(headerPrivateAreaButton).click();
    }

    //Нажать на логотип
    @Step("Click logotype")
    public void clickLogotype() {
        clickPrivateArea();
        driver.findElement(headerLogotypeButton).click();

    }
}
