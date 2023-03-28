package Commencis.pages;

import Commencis.utils.Drivers;
import Commencis.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(Drivers.get(), this);
    }

    public By newsWrapper = By.className("post-block--unread");
    public By newsAuthors = By.className("river-byline__authors");
    public By newsImages = By.cssSelector(".post-block__media source");


    public void verifyAuthor() {
        List<WebElement> articles = Drivers.get().findElements(newsWrapper);

        for (WebElement article : articles) {
            WebElement author = article.findElement(newsAuthors);

            Assert.assertTrue(author.getText().length() > 0 && author.isDisplayed());
        }
    }

    public void verifyImages() {
        List<WebElement> articles = Drivers.get().findElements(newsWrapper);

        for (WebElement article : articles) {
            List<WebElement> imageSources = article.findElements(newsImages);

            for (WebElement image : imageSources) {
                Assert.assertTrue(Helpers.isValidURL(image.getAttribute("srcset").split(" ")[0]));
            }

        }
    }

    public void clickRandomArticle() {
        List<WebElement> articles = Drivers.get().findElements(newsWrapper);
        int randomIndex = Helpers.getRandomIndex(0, articles.size());
        articles.get(randomIndex).click();
    }
}
