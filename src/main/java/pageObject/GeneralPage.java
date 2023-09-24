package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class GeneralPage {

    private WebDriver driver;

    public GeneralPage(WebDriver driver) {
        this.driver = driver;
    }


    // Find email field
    private By emailField = By.id("cl_login");

    //Button "Weiter"
    private By buttonWeiter = By.xpath(".//*[@value = 'weiter']");

    //Checkbox Guest
    private By checkboxGuest = By.className("c24-uli-cl-box-option style-scope unified-login");


    //Button Register
    private By registerButton = By.id("c24-uli-register-btn");

    // SignIn Form
    private By signInFormName = By.xpath(".//*[text()='Persönliche Angaben'");


    @Step("Enter email")
    public void enterEmails(String email) {
        waitEmailForm();
        driver.findElement(emailField).sendKeys(email);
    }


    @Step("Click Weiter")
    public void clickWeiter() {
        driver.findElement(buttonWeiter).click();
    }


    @Step("Select checkbox Guest")
    public void selectCheckboxGuest() {
        waitRegisterForm();
        driver.findElement(checkboxGuest).click();
    }

    @Step("Click register Button")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }


    //Load of email form
    public void waitEmailForm() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(emailField));

    }

    //Load of Register form
    public void waitRegisterForm() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(checkboxGuest));

    }

    //Load of Sign In form
    public void waitSignInForm() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOfElementLocated(signInFormName));

    }


    @Step("Fill register form for Guest")
    public void fillRegisterForGuest(String email) {
        enterEmails(email);
        clickWeiter();
        selectCheckboxGuest();
        clickRegisterButton();

    }


}
