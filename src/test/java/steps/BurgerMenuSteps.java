package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.saucedemo.BurgerMenuPage;
import pages.saucedemo.LoginPage;
import utilities.CommonFlows;

public class BurgerMenuSteps {

    private final CommonFlows commonFlows = new CommonFlows();
    private final BurgerMenuPage burgerMenuPage = new BurgerMenuPage();
    private final LoginPage loginPage = new LoginPage();

    @Given("The user is logged in and open the burger menu")
    public void openBurgerMenu() {
        commonFlows.openBurgerMenu();
    }

    @When("The user clicks on the logout option")
    public void clickLogout() {
        burgerMenuPage.clickLogout();
    }

    @Then("The application redirects to the login page")
    public void redirectLoginPage() {
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }


    @Then("The user verifies that the about link is {string}")
    public void verifyAboutLink(String expectedLink) {
        burgerMenuPage.verifyAboutOption(expectedLink);
    }
}
