package products;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CategoriesTest extends Pages {

    @Test
    @DisplayName("Categories")
    @Tag("Products")
    @RepeatedTest(10)
    public void verifyDetailsInCategories() {

        for (int i = 0; i< topMenuPage.countAvailableMainCategories(); i++) {
            //TODO poprawić aby nie było WebElementu
            topMenuPage.getRequiredMainCategory(i).click();
            topMenuPage.waitToBeVisible(topMenuPage.getRequiredMainCategory(i));

            String categoryName = topMenuPage.getRequiredMainCategory(i).getText();

            softly.assertThat(driver.getTitle().toUpperCase()).isEqualTo(categoryName);

            String countedProducts = productGridPage.getAmountOfProducts();
            String labelCounterText = searchResultsPage.readTextForFoundedProducts();

            softly.assertThat(labelCounterText).contains(countedProducts);
        }
        softly.assertAll();
    }
}
