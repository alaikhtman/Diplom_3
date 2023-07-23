import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import pageObject.SignInPage;
import pageObject.MainPage;
import pageObject.HeaderPage;
import pageObject.PersonalAreaPage;

public class PersonalAreaTest extends BaseTest {

    String name = RandomStringUtils.randomAlphabetic(10);
    String email = RandomStringUtils.randomAlphabetic(10) + "@mail.ru";
    String password = RandomStringUtils.randomAlphabetic(10);

    @Before
    public void setUp() {
        startUp("yandex");
    }

    @Test
    @DisplayName("PrivateArea: private area -> main page by logotype")
    @Description("PrivateArea: transition from private area to main page by logotype")
    public void fromPrivateAreaToMainPageByLogotypeTest() {
        signUpUser(name, email, password);
        signInUser(email, password);

        HeaderPage header = new HeaderPage(driver);
        header.clickPrivateArea();
        header.clickLogotype();

        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage();


    }

    @Test
    @DisplayName("PrivateArea: private area -> main page by main page button")
    @Description("PrivateArea: transition from private area to main page by main page button")
    public void fromPrivateAreaToMainPageByConstructionButtonTest() {
        signUpUser(name, email, password);
        signInUser(email, password);

        HeaderPage header = new HeaderPage(driver);
        header.clickPrivateArea();
        header.clickMainPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.checkMainPage();

    }



    @Test
    @DisplayName("PrivateArea: exit button")
    @Description("PrivateArea: exit button flow")
    public void privateAreaExitButtonTest() {
        signUpUser(name, email, password);
        signInUser(email, password);

        HeaderPage header = new HeaderPage(driver);
        header.clickPrivateArea();

        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        personalAreaPage.clickExit();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.checkSignInPage();


    }

}
