package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HeaderPage {

    private WebDriver driver;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка главной страницы
    private By headerMainPageButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/ul/li[1]/a");

    //Логотип
    private By headerLogotypeButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/div/a");

    //Кнопка личного кабинета
    private By headerProfileButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/a");


    //Нажать на кнопку главной страницы
    @Step("Click main page button")
    public void clickMainPage() {
        driver.findElement(headerMainPageButton).click();
    }

    //Нажатие на кнопку личного кабинета
    @Step("Click profile")
    public void clickProfileButton() {
        driver.findElement(headerProfileButton).click();
    }

    //Нажать на логотип
    @Step("Click logotype")
    public void clickLogotype() {
        driver.findElement(headerLogotypeButton).click();

    }
}
