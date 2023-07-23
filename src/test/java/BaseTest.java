import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import pageObject.*;

import static config.Config.URL;

public class BaseTest {

    WebDriver driver;


    public void startUp(String browser) {

        switch (browser) {
            case "yandex":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                driver.get(URL);
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(URL);
                break;
        }
    }



    @After
    public void tearDown() {
        driver.quit();
    }

    public void signUpUser(String name, String email, String password) {
        HeaderPage header = new HeaderPage(driver);
        header.clickPrivateArea();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.clickRegistrationButton();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUpUser(name, email, password);
    }

    public void signInUser(String email, String password) {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signInUser(email, password);
    }

    public void checkAccountData(String name, String email) {
        HeaderPage header = new HeaderPage(driver);
        header.clickPrivateArea();

        PersonalAreaPage personalAreaPage = new PersonalAreaPage(driver);
        personalAreaPage.checkAccountsData(name, email);
    }


}
