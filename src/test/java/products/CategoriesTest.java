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

        for (int i = 0; i< topMenuPage.sizeOfMainCategoryList(); i++) {
            topMenuPage.getMainCategory(i).click();
            topMenuPage.waitToBeVisible(topMenuPage.getMainCategory(i));
            String categoryName = topMenuPage.getMainCategory(i).getText();

            softly.assertThat(driver.getTitle().toUpperCase()).isEqualTo(categoryName);

            String countedProducts = productGridPage.countProductsOnList();
            String labelCounterText = searchResultsPage.readTextForFoundedProducts();

            softly.assertThat(labelCounterText).contains(countedProducts);
        }
        softly.assertAll();
    }
}
