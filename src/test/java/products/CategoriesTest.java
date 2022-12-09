package products;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.menu.TopMenuPage;

public class CategoriesTest extends Pages {

    @Test
    @DisplayName("Categories")
    @Tag("Products")
    @RepeatedTest(10)
    public void verifyDetailsInCategories() {

        for (int i = 0; i< topMenuPage.countAvailableMainCategories(); i++) {
            topMenuPage.goToRequiredMainCategory(i);

            String categoryName = topMenuPage.getRequiredMainCategoryTitle(i);

            softly.assertThat(topMenuPage.getPageTitle()).isEqualTo(categoryName);

            String countedProducts = productGridPage.getAmountOfProducts();
            String labelCounterText = searchResultsPage.readTextForFoundedProducts();

            softly.assertThat(labelCounterText).contains(countedProducts);
        }
        softly.assertAll();
    }
}
