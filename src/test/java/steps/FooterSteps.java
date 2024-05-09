package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.saucedemo.FooterPage;

public class FooterSteps {

    private final FooterPage footerPage = new FooterPage();

    @Then("The user verifies that the links are right: {string}, {string}, {string}")
    public void verifySocialMediaLinks(String twitterUrl, String linkedinUrl, String facebookUrl) {
        footerPage.verifySocialMediaLinks(twitterUrl, linkedinUrl, facebookUrl);
    }
}
