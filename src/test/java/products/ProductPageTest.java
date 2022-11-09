package products;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProductPageTest extends Pages {

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

    @Test
    @DisplayName("Filters")
    @Tag("Products")
    @RepeatedTest(10)
    public void filterSliderShouldBeDraggable() throws InterruptedException {
        topMenuPage.clickArtCategory();
        filterPage.moveLeftSliderHandle();
        filterPage.moveRightSliderHandle();

        for (int i = 0; i < productGridPage.getSizeOfProductPricesList() ; i++) {
            softly.assertThat(productGridPage.getVisibleProductsPrices(i))
                    .isGreaterThanOrEqualTo(filterPage.getMinimumPrice());
            softly.assertThat(productGridPage.getVisibleProductsPrices(i))
                    .isLessThanOrEqualTo(filterPage.getMaximumPrice());
        }
        softly.assertAll();
    }
}
