package products;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MouseHoverTest extends Pages {

    @Test
    @DisplayName("Hover Mouse and click on Men Subcategory")
    @Tag("Mouse")
    public void hoverOnMenSubcategoryTest() {
        topMenuPage.moveMouseToClothes();

        String requestedCategory = topMenuPage.getMenCategoryText().toUpperCase();

        topMenuPage.goToMenSubcategory();

        assertThat(categoryPage.getCategoryName(), equalTo(requestedCategory));
    }

    @Test
    @DisplayName("Hover Mouse and click on Home Accessories Subcategory")
    @Tag("Mouse")
    public void hoverOnHomeAccessoriesSubcategoryTest() {
        topMenuPage.moveMouseToAccessories();

        String requestedCategory = topMenuPage.getHomeAccessoriesCategoryText().toUpperCase();

        topMenuPage.goToHomeAccessoriesSubcategory();

        assertThat(categoryPage.getCategoryName(), equalTo(requestedCategory));
    }

    @Test
    @DisplayName("Hover Mouse and click to Art Category")
    @Tag("Mouse")
    public void hoverOnArtCategoryTest() {
        String requestedCategory = topMenuPage.getArtCategoryText().toUpperCase();

        topMenuPage.moveMouseToArt()
                .goToArtCategory();

        assertThat(categoryPage.getCategoryName(), equalTo(requestedCategory));
    }

}
