package Commencis.step_def;

import Commencis.pages.HomePage;
import Commencis.utils.ConfReader;
import Commencis.utils.Drivers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    HomePage homePage = new HomePage();

    @Given("Go to Techcrunch website")
    public void goToTechcrunchWebsite() {
        Drivers.get().get(ConfReader.get("baseUrl"));
    }

    @Then("Each news has an author")
    public void eachNewsHasAnAuthor() {
        homePage.verifyAuthor();
    }

    @And("Each news has an image")
    public void eachNewsHasAnImage() {
        homePage.verifyImages();
    }

    @When("Click Random Article")
    public void clickRandomArticle() {
        homePage.clickRandomArticle();
    }
}
