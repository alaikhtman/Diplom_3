import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.MainPage;

public class MainPageTest extends BaseTest {


    @Test
    @DisplayName("Main Page: check cookies")
    public void checkCookieTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.acceptCookieInfo();
        mainPage.checkCookies("kreditkarte");


    }


}
