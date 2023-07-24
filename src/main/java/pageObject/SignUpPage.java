package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    //Поел имени
    public By nameField = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input");

    //Поле имейла
    public By emailField = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input");

    //Поле пароля
    public By passwordField = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input");

    //Кнопка зарегистрироваться
    public By registrationButton = By.xpath(".//*[@id=\"root\"]/div/main/div/form/button");

    //Ошибка при некорректном пароле
    public By errorIncorrectPassword = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/p");

    //Кнопка для авторизации
    public By signInButton = By.xpath(".//*[@id=\"root\"]/div/main/div/div/p/a");

    //Заполнить имя
    @Step("Fill the name")
    public void fillNameField(String name) {
        assertTrue(driver.findElement(nameField).isEnabled());
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);

    }

    //Заполнить емейл
    @Step("Fill the email")
    public void fillEmailField(String email) {
        assertTrue(driver.findElement(emailField).isEnabled());
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);

    }

    //Заполнить пароль
    @Step("Fill the password")
    public void fillPasswordField(String password) {
        assertTrue(driver.findElement(passwordField).isEnabled());
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    //Нажать на кнопку регистрации
    @Step("Click signUp button on signUp form")
    public void clickSignUpButton() {
        driver.findElement(registrationButton).click();
    }


    //Зарегистрировать пользователя
    @Step("Sign up user")
    public void signUpUser(String name, String email, String password) {
        fillNameField(name);
        fillEmailField(email);
        fillPasswordField(password);
        clickSignUpButton();
    }

    //Проверить ошибку в пароле
    @Step("Check password error")
    public void checkPasswordError() {
        assertTrue(driver.findElement(errorIncorrectPassword).isEnabled());
    }

    //Нажатие на кнопку авторизации
    @Step("Click signIn button on signUp page")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(signInButton));
    }

}
