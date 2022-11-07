package products;

import base.Pages;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import pages.menu.TopMenuPage;

import java.time.Duration;
import java.util.List;

public class ProductPageTest extends Pages {

    SoftAssertions softly = new SoftAssertions();

    //TODO jest error z StaleElementReferenceException, poszukaj i popraw
    @Test
    @DisplayName("Categories")
    @Tag("Products")
    public void verifyDetailsInCategories() {

        List<WebElement> mainCategory = driver.findElements(By.xpath("//a[@data-depth=\"0\"]"));

        for (WebElement category : mainCategory) {
            category.click();
         //   topMenuPage.waitToBeVisible(category);
            System.out.println(category.getText());
            String categoryName = category.getText();
            softly.assertThat(driver.getTitle().toUpperCase()).isEqualTo(categoryName);
            String countedProducts = productList.countProductsOnList();
            String labelCounterText = searchResultsPage.readTextForFoundedProducts();
            softly.assertThat(labelCounterText).contains(countedProducts);
        }
        softly.assertAll();
    }

    @Test
    @DisplayName("Filters")
    @Tag("Products")
    //@RepeatedTest(10)
    public void filterSliderShouldBeDraggable() {
        topMenuPage.clickArtCategory();
        filterPage.checkFilterSlider();
        String priceRange = filterPage.getFilterPriceText();
        Assertions.assertThat(priceRange).isEqualTo(System.getProperty("priceFilterTag"));
    }
}
