package pages.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class TopBarPage extends BasePage {

    private final By title = By.xpath("//div[text()='Swag Labs']");
    private final By burgerMenu = By.id("react-burger-menu-btn");

    @Override
    public void waitPageToLoad() { }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(title).isDisplayed()),
                () -> Assertions.assertTrue(find(burgerMenu).isDisplayed())
        );
    }

    public void openBurgerMenu() {
        Logs.info("Opening the burger menu");
        find(burgerMenu).click();
    }
}
