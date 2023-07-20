package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConstructionPage {
    private WebDriver driver;

    public ConstructionPage(WebDriver driver) {
        this.driver = driver;
    }

    //Кнопка личного кабинета
    private By headerPrivateAreaButton = By.xpath(".//*[@id=\"root\"]/div/header/nav/a");

    //Раздел "Булки"
    private By bunSection = By.xpath(".//*[@id=\"root\"]/div/main/section[1]/div[1]/div[1]");
    //Раздел "Соусы"
    private By saucesSection = By.xpath(".//*[@id=\"root\"]/div/main/section[1]/div[1]/div[2]");
    //Раздел "Начинки"
    private By fillingsSection = By.xpath(".//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]");

    //Нажатие на кнопку личного кабинета
    @Step("Click private area")
    public void clickPrivateArea() {
        driver.findElement(headerPrivateAreaButton).click();
    }


    //Нажать  на раздел "Булки"
    @Step("Select buns section")
    public void selectBuns() {
        driver.findElement(bunSection).click();
    }


    //Нажать  на раздел "Соусы"
    @Step("Select sauces section")
    public void selectSauce() {
        driver.findElement(saucesSection).click();
    }


    //Нажать  на раздел "Начинки"
    @Step("Select fillings section")
    public void selectFilling() {
        driver.findElement(fillingsSection).click();
    }
}
