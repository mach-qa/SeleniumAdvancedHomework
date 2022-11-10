package search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends Pages {

    @Test
    @DisplayName("Standard Search Test")
    @Tag("Search")
    @RepeatedTest(10)
    public void shouldPerformSearch() {

        String productInputText = productGridPage.getRandomProductText();
        topMenuPage.fillSearchInputField(productInputText);
        topMenuPage.performSearch();

        String quantity = searchResultsPage.readAmountOfFoundedProducts();
        softly.assertThat(quantity).isEqualTo(productGridPage.countProductsOnList());

        List<String> allProductsName = productGridPage.getVisibleProductsName();
        softly.assertThat(allProductsName).contains(productInputText);

        softly.assertAll();
    }

    @Test
    @DisplayName("Dropdown Search")
    @Tag("Search")
    @RepeatedTest(10)
    public void dropdownShouldContainEnteredText() {
        topMenuPage.fillSearchInputField(System.getProperty("searchInput"));
        topMenuPage.waitForDropdownList();
        boolean result = topMenuPage.verifyProductsInDropdown();

        assertThat(result).isEqualTo(true);
    }
}
