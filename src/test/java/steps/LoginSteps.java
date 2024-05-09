package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.saucedemo.LoginPage;
import utilities.CommonFlows;

public class LoginSteps {

    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();

    @Given("The user navigates to the login page")
    public void navigateToTheLoginPage() {
        commonFlows.goToLoginPage();
    }

    @When("The user types the username {string} with the password {string} and clicks on the login button")
    public void fillLoginForm(String username, String password) {
        loginPage.fillLogin(username, password);
    }

    @Then("An error message must be displayed indicating {string}")
    public void verifyErrorMessage(String errorText) {
       loginPage.verifyErrorMessage(errorText);
    }

    @Then("The user verifies that the login page UI is right")
    public void verifyUiLoginPage() {
        loginPage.verifyPage();
    }
}
