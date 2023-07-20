import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.ConstructionPage;

import static config.Config.URL;

public class BaseTest {

    WebDriver driver;

    @Before
    public void startUp() {

        WebDriverManager.chromedriver().setup();
        ConstructionPage mainPage = new ConstructionPage(driver);
        driver = new ChromeDriver();
        driver.get(URL);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}