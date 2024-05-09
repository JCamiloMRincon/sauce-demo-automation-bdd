package pages.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class LoginPage extends BasePage {

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @Override
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verifying the login page");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(usernameInput).isDisplayed()),
                () -> Assertions.assertTrue(find(passwordInput).isDisplayed()),
                () -> Assertions.assertTrue(find(loginButton).isDisplayed())
        );
    }

    public void fillLogin(String username, String password) {
        Logs.info("Writing the username");
        find(usernameInput).sendKeys(username);

        Logs.info("Writing the password");
        find(passwordInput).sendKeys(password);

        Logs.info("Click on the login button");
        find(loginButton).click();
    }

    public void verifyErrorMessage(String errorText) {
        final var errorLabel = find(errorMessage);

        Logs.info("Verifying the error message");
        Assertions.assertAll(
                () -> Assertions.assertTrue(errorLabel.isDisplayed()),
                () -> Assertions.assertEquals(errorLabel.getText(), errorText)
        );
    }
}
