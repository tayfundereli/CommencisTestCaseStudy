package Commencis.pages;

import Commencis.utils.Drivers;
import Commencis.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ArticlePage {
    public ArticlePage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    @FindBy(className = "article__title")
    public WebElement articleTitle;

    public By articleLinks = By.cssSelector(".article-container a");

    public void checkBrowserTitleAndArticleTitle() {
        Assert.assertTrue(Drivers.get().getTitle().contains(articleTitle.getText()), "Article title is not same with the browser title");
    }

    public void checkURLAndTheNewsContent() {
        String articleTitleWithoutSpecialCharacters = articleTitle.getText().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String[] urlWithoutSlashes = Drivers.get().getCurrentUrl().split("/");
        String urlArticleWithoutDashes = urlWithoutSlashes[urlWithoutSlashes.length - 1].replaceAll("-", "");

        Assert.assertEquals(articleTitleWithoutSpecialCharacters, urlArticleWithoutDashes, String.format("Article title is not same with the URL Title: %s", Drivers.get().getCurrentUrl()));
    }

    public void verifyArticleLinks() {
        List<WebElement> linkElements = Drivers.get().findElements(articleLinks);

        for (WebElement linkElement : linkElements) {
            String link = linkElement.getAttribute("href");

            if (!link.contains("mailto:")) Assert.assertTrue(Helpers.isValidURL(link));
        }
    }
}
