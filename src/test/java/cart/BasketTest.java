package cart;

import base.Pages;
import models.Cart;
import models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BasketTest extends Pages {

    @Test
    @Tag("Basket")
    @DisplayName("Verify Dialog")
    public void productShouldBeAdded () {

        Cart expectedCart = new Cart();

        topMenuPage.clickArtCategory();
        productGridPage.clickOnRequestedTitle();

        productDetailsPage.waitForQuantityInput();
        productDetailsPage.setNewQuantity();
        expectedCart.addProduct(productDetailsPage.saveProductDetails());
        productDetailsPage.addProductToCart();

//        for (int i = 0; i < expectedCart.sizeOfCart(); i++) {
//            softly.assertThat(expectedCart.getProducts().get(i).getProductName())
//                    .isEqualTo(productDetailsPage.getAddedProductTitle());
//
//            softly.assertThat(expectedCart.getProducts().get(i).getPrice())
//                    .isEqualTo(productDetailsPage.getAddedProductPrice());
//
//            softly.assertThat(expectedCart.getProducts().get(i).getQuantity())
//                    .isEqualTo(productDetailsPage.getAddedProductQuantity());
//        }
        for (Product product: expectedCart.getCartList()) {
            softly.assertThat(product.getProductName()).isEqualTo(productDetailsPage.getAddedProductTitle());
            softly.assertThat(product.getPrice()).isEqualTo(productDetailsPage.getAddedProductPrice());
            softly.assertThat(product.getQuantity()).isEqualTo(productDetailsPage.getAddedProductQuantity());
        }

        softly.assertAll();
    }
}
