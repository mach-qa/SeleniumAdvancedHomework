package search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DropdownSearchTest extends Pages {

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