package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

public class SignInPage {

    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка регистрации
    public By registrationButton = By.xpath(".//*[@id=\"root\"]/div/main/div/div/p[1]/a");

    //Кнопка входа
    public By entranceButton = By.xpath(".//*[@id=\"root\"]/div/main/div/form/button");

    //Поле имейла
    public By emailField = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    //Поле пароля
    public By passwordField = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    //Текст Вход
    public By entranceText = By.xpath(".//*[@id=\"root\"]/div/main/div/h2[text()='Вход']");



    //Кнопка для восстановления пароля
    public By restorePasswordButton = By.xpath(".//*[@id=\"root\"]/div/main/div/div/p[2]/a");


    //Заполнить емейл
    @Step("Fill an email")
    public void fillEmailField(String email) {
        assertTrue(driver.findElement(emailField).isEnabled());
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

    }

    //Заполнить пароль
    @Step("Fill a password")
    public void fillPasswordField(String password) {
        assertTrue(driver.findElement(passwordField).isEnabled());
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }


    //Нажатие на кнопку регистрации
    @Step("Click registration button")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    //Нажатие на кнопку войти
    @Step("Click entrance button")
    public void clickEntranceButton() {
        driver.findElement(entranceButton).click();
    }



    //Нажатие на кнопку забыл пароль
    @Step("Click password button")
    public void clickPasswordRestoreButton() {
        driver.findElement(restorePasswordButton).click();
         }

    //Ожидание загрузки страницы
    public void waitSignInPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(entranceText));

    }


    //Авторизовать пользователя
    @Step("Sign in user")
    public void signInUser(String email, String password) {
        waitSignInPage();
        fillEmailField(email);
        fillPasswordField(password);
        clickEntranceButton();

    }

    //Нажатие кнопки авторизации
    public void checkSignInPage() {
        waitSignInPage();
        assert(driver.findElement(emailField).getAttribute("value").isEmpty());
        assert(driver.findElement(passwordField).getAttribute("value").isEmpty());
    }

}
