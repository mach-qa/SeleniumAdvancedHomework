package search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SearchTest extends Pages {

    @Test
    @DisplayName("Standard Search Test")
    @Tag("Search")
    @RepeatedTest(10)
    public void shouldPerformSearch() {

        String productInputText = productGridPage.getRandomProductText();
        topMenuPage.fillSearchInputField(productInputText)
                .performSearch();

        String quantity = searchResultsPage.saveAmountOfFoundProducts();
        softly.assertThat(quantity).isEqualTo(productGridPage.getAmountOfProducts());

        List<String> allProductsName = productGridPage.getVisibleProductsName();
        softly.assertThat(allProductsName).contains(productInputText);

        softly.assertAll();
    }
}
