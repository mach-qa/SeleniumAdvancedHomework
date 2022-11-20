package products;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class FiltersTest extends Pages {

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
