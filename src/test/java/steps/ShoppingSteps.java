package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.saucedemo.ShoppingPage;
import utilities.CommonFlows;

public class ShoppingSteps {

    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @Given("The user navigates to the shopping page")
    public void navigateToTheShoppingPage() {
        commonFlows.goToShoppingPage();
    }

    @Then("The user verifies that the shopping page UI is right")
    public void verifyUiShoppingPage() {
        shoppingPage.verifyPage();
    }
}
