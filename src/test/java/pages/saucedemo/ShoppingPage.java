package pages.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ShoppingPage extends BasePage {

    private final By inventoryList = By.className("inventory_list");
    private final By productsTitle = By.xpath("//span[text()='Products']");
    private final By selectItem = By.cssSelector("select[data-test='product-sort-container']");

    private By getItemName(String itemName) {
        // Dynamic locator
        final var xpath = String.format("//div[text()='%s']", itemName);
        return By.xpath(xpath);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(inventoryList, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        Logs.info("Verifying the shopping page");
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(inventoryList).isDisplayed()),
                () -> Assertions.assertTrue(find(productsTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(selectItem).isDisplayed())
        );
    }

    public void goToItemDetails(String itemName) {
        Logs.info("Navigating to the details of the item: %s", itemName);
        find(getItemName(itemName)).click();
    }
}
