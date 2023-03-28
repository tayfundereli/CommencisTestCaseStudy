package Commencis.step_def;

import Commencis.pages.ArticlePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ArticlePageSteps {
    ArticlePage articlePage = new ArticlePage();

    @Then("The browser title is the same with the news title")
    public void theBrowserTitleIsTheSameWithTheNewsTitle() {
        articlePage.checkBrowserTitleAndArticleTitle();
    }

    @And("Links within the news content")
    public void linksWithinTheNewsContent() {
        articlePage.verifyArticleLinks();
        articlePage.checkURLAndTheNewsContent();
    }
}
