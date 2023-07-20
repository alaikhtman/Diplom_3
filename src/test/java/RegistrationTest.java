import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pageObject.AuthPage;
import pageObject.ConstructionPage;
import pageObject.PrivateAreaPage;
import pageObject.RegistrationPage;


public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("SignUp: positive flow")
    @Description("Sign Up user: positive flow for successfully registration")
    public void registrationTest() {

        String name = RandomStringUtils.randomAlphabetic(10);
        String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
        String password = RandomStringUtils.randomAlphabetic(10);

        ConstructionPage constructionPage = new ConstructionPage(driver);
        constructionPage.clickPrivateArea();

        AuthPage authPage = new AuthPage(driver);
        authPage.clickRegistrationButton();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.signUpUser(name, email, password);

        authPage.signInUser(email, password);
        constructionPage.clickPrivateArea();

        PrivateAreaPage privateAreaPage = new PrivateAreaPage(driver);
        privateAreaPage.checkAccountsData(name, email);


    }

    @Test
    @DisplayName("SignUp: incorrect password (less than 6 symbols)")
    @Description("Sign Up user: negative flow for unsuccessfully registration when password less than 6 symbols")

    public void registrationUnsuccessfullyIncorrectPasswordTest() {

    }
}
