package search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.everyItem;

public class DropdownSearchTest extends Pages {

    @Test
    @DisplayName("Dropdown Search")
    @Tag("Search")
    @RepeatedTest(10)
    public void dropdownShouldContainEnteredText() {

        topMenuPage.fillSearchInputField(System.getProperty("searchInput"));
        List<String> list = topMenuPage.getSearchResults();
        assertThat(list, (everyItem(containsString(System.getProperty("searchInput")))));
    }
}
