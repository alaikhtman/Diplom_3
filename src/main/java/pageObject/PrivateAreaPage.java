package pageObject;

import io.qameta.allure.Step;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

public class PrivateAreaPage {
    private WebDriver driver;

    public PrivateAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поле имени
    public By nameField = By.xpath(".//*[@id=\"root\"]/div/main/div/div/div/ul/li[1]/div/div/input");

    //Поле имейла
    public By emailField = By.xpath(".//*[@id=\"root\"]/div/main/div/div/div/ul/li[2]/div/div/input");


    //Кнопка выхода
    public By exitButton = By.xpath(".//*[@id=\"root\"]/div/main/div/nav/ul/li[3]/button[text()='Выход']");

    //Кнопка конструктора
    public By headerConstructionButton = By.className("AppHeader_header__linkText__3q_va ml-2");

    //Логотип
    public By headerLogotypeButton = By.className("AppHeader_header__logo__2D0X2");


    public void waitUntilAccountDetails() {

        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));


    }

    //Получить имя
    @Step("Get the name")
    public String getName() {
        String name = driver.findElement(nameField).getAttribute("value");
        return name;
    }


    // Получить имейл
    @Step("Get the email")
    public String getEmail() {
        String email = driver.findElement(emailField).getAttribute("value");
        return email;
    }


    //Нажать на выход
    @Step("Click exit button")
    public void clickExit() {
        driver.findElement(exitButton).click();
    }

    //Нажать на конструктор
    @Step("Click construction button")
    public void clickConstruction() {
        driver.findElement(headerConstructionButton).click();
    }

    //Нажать на логотип
    @Step("Click logotype")
    public void clickLogotype() {
        driver.findElement(headerLogotypeButton).click();
    }

    //Проверить данные
    public void checkAccountsData(String name, String email) {
        waitUntilAccountDetails();
        String formattedEmail = email.toLowerCase(Locale.ROOT);
        assertEquals(name, getName());
        assertEquals(formattedEmail, getEmail());
    }

}
