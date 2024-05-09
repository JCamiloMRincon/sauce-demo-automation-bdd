package pages.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class BurgerMenuPage extends BasePage {

    private final By logoutButton = By.id("logout_sidebar_link");
    private final By aboutButton = By.id("about_sidebar_link");

    @Override
    public void waitPageToLoad() {
        waitPage(logoutButton, this.getClass().getSimpleName());

        Logs.info("Waiting for the logout button to be clickable because it has an animation");
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    }

    @Override
    public void verifyPage() {
        Logs.info("Verifying the burger menu");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(logoutButton).isDisplayed()),
                () -> Assertions.assertTrue(find(aboutButton).isDisplayed())
        );
    }

    public void clickLogout() {
        Logs.info("Click on the logout option");
        find(logoutButton).click();
    }

    public void verifyAboutOption(String expectedUrl) {
        final var aboutLink=find(aboutButton);

        Logs.info("Verifying the about hyperlink");
        Assertions.assertAll(
                () -> Assertions.assertTrue(aboutLink.isDisplayed()),
                () -> Assertions.assertTrue(aboutLink.isEnabled()),
                () -> Assertions.assertEquals(aboutLink.getAttribute("href"), expectedUrl)
        );
    }
}
