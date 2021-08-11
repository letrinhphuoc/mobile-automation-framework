package phuoclet.test.cucumber.stepdefinition;

import com.google.inject.Inject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import phuoclet.test.pages.abstractpages.ContactDetailPage;
import phuoclet.test.pages.abstractpages.ContactSearchPage;

public class Contact {
    @Inject
    private ContactSearchPage searchPage;

    @Inject
    private ContactDetailPage detailPage;

    @Given("I search {string}")
    public void iSearch(String keyword) {
        searchPage.search(keyword);
    }

    @Then("I verify first contact is {string}")
    public void iVerifyFirstContactIs(String name) {
        Assert.assertEquals(searchPage.getFirstContact(), name);
    }

    @When("I navigate to search result details")
    public void iNavigateToSearchResultDetails() {
        searchPage.navigateToSearchResultDetails();
    }

    @Then("I verify contact name {string}")
    public void iVerifyContactName(String name) {
        Assert.assertEquals(detailPage.getContactName(), name);
    }
}
