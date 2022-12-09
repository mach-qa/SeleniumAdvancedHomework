package cart.basket;

import base.Pages;
import models.Cart;
import models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest extends Pages {

    @Test
    @Tag("Basket")
    @DisplayName("Verify modal dialog after add Product")
    public void productShouldBeAdded() {

        topMenuPage.goToArtCategory();

        productGridPage.clickOnRequestedProduct();
        productDetailsPage.setNewQuantity();

        Product product = productDetailsPage.saveProductDetails();

        productDetailsPage.addProductToCart();

        Product addedProduct = popUpCartPage.getProduct();

        assertThat(product).usingRecursiveComparison().isEqualTo(addedProduct);

        softly.assertThat(popUpCartPage.getProductSubtotalPrice()).isEqualTo(product.getTotalPrice());
        softly.assertThat(popUpCartPage.getCartCounterText()).contains(String.valueOf(product.getQuantity()));

        softly.assertAll();
    }

    @Test
    @Tag("Basket")
    @DisplayName("Basket Calculation")
    public void basketShouldContainAddedProducts() {

        Cart expectedCart = new Cart();

        for (int i = 0; i < Integer.parseInt(System.getProperty("numberOfProductsAddedToCart")); i++) {
            productGridPage.clickOnRandomProduct();

            productDetailsPage.setRandomQuantity()
                            .waitForQuantityInput();

            expectedCart.addProduct(productDetailsPage.saveProductDetails());

            productDetailsPage.addProductToCart();
            popUpCartPage.continueShopping();

            topMenuPage.navigateToHomePage();
        }
        topMenuPage.goToCartPage();

        assertThat(cartPage.toCart()).usingRecursiveComparison().isEqualTo(expectedCart);
    }

}
