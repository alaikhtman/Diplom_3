package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RestorePasswordPage {

    private WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка авторизации
    public By signInButton = By.xpath(".//*[@id=\"root\"]/div/main/div/div/p/a");

    //Текст страницы
    public By restorePasswordText = By.xpath((".//*[@id=\"root\"]/div/main/div/h2"));

    //Ожидание загрузки страницы
    public void waitRestorePage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(restorePasswordText));

    }

    //Нажатие кнопки авторизации
    @Step("Click signIn button on restore page")
    public void clickSignInButton() {
        waitRestorePage();
        driver.findElement(signInButton).click();
    }
}
