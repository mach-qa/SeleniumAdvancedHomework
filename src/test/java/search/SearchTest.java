package search;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends Pages {

    SoftAssertions softly = new SoftAssertions();

    @Test
    @DisplayName("Standard Search Test")
    @Tag("Search")
    @RepeatedTest(10)
    public void shouldPerformSearch () {

        String productInputText = productList.getRandomProductText();
        topMenuPage.fillSearchInputField(productInputText);
        topMenuPage.performSearch();
        String quantity = searchResultsPage.readAmountOfFoundedProducts();

        softly.assertThat(quantity).isEqualTo(productList.countProductsOnList());
//      softly.assertThat(productList.getVisibleProductsText()).isEqualTo(productInputText);

        List<String> allProductsName = productList.getVisibleProductsName();
        softly.assertThat(allProductsName).contains(productInputText);

        softly.assertAll();
    }

    @Test
    @DisplayName("Dropdown Search")
    @Tag("Search")
    @RepeatedTest(10)
    public void dropdownShouldContainEnteredText () {
        topMenuPage.fillSearchInputField(System.getProperty("searchInput"));
        topMenuPage.waitForDropdownList();
        boolean result = topMenuPage.verifyProductsInDropdown();

        assertThat(result).isEqualTo(true);
    }
}
