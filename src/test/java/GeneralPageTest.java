import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.GeneralPage;



public class GeneralPageTest extends BaseTest {

    @Test
    @DisplayName("GeneralTest Page: check cookies")
    public void checkSignInTest() {

        GeneralPage generalPage = new GeneralPage(driver);
        generalPage.fillRegisterForGuest("test@gmail.com");

    }
}
