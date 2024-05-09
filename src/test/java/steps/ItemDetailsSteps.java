package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.saucedemo.ItemDetailsPage;
import pages.saucedemo.ShoppingPage;
import utilities.CommonFlows;

public class ItemDetailsSteps {

    private final CommonFlows commonFlows = new CommonFlows();
    private final ItemDetailsPage itemDetailsPage = new ItemDetailsPage();
    private final ShoppingPage shoppingPage = new ShoppingPage();

    @Given("The user navigates to the details of the item {string}")
    public void navigateToItemDetails(String name) {
        commonFlows.goToItemDetail(name);
    }

    @Then("The user verifies that the item details UI is right")
    public void verifyUiItemDetailsPage() {
        itemDetailsPage.verifyPage();
    }

    @When("The user clicks on back to products")
    public void clickOnBackToProducts() {
        itemDetailsPage.clickBackToProducts();
    }

    @Then("The application redirects to the shopping page")
    public void redirectShoppingPage() {
        shoppingPage.waitPageToLoad();
        shoppingPage.verifyPage();
    }
}
