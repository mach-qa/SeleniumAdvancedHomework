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

//        Cart expectedCart = new Cart();
//
//        topMenuPage.goToArtCategory();
//
//        productGridPage.clickOnRequestedProduct();
//        productDetailsPage.setNewQuantity();
//
//        expectedCart.addProduct(productDetailsPage.saveProductDetails());
//
//        productDetailsPage.addProductToCart();
//
//        //TODO Pomyslec czy nie można zrobić tego jak ponizej z wykorzystaniem usingRecursiveComparison()
//
//        for (Product product : expectedCart.getAmountOfProductsInCart()) {
//            softly.assertThat(product.getProductName()).isEqualTo(modalDialogPage.getAddedProductTitle());
//            softly.assertThat(product.getPrice()).isEqualTo(modalDialogPage.getAddedProductPrice());
//            softly.assertThat(product.getTotalPrice()).isEqualTo(modalDialogPage.getAddedProductSubtotalPrice());
//            softly.assertThat(product.getQuantity()).hasToString(modalDialogPage.getCartCounterText());
//        }
//        softly.assertAll();

        topMenuPage.goToArtCategory();

        productGridPage.clickOnRequestedProduct();
        productDetailsPage.setNewQuantity();

        Product product = productDetailsPage.saveProductDetails();

        productDetailsPage.addProductToCart();

        Product addedProduct = popUpCartPage.getProduct();

        assertThat(product).usingRecursiveComparison().isEqualTo(addedProduct);

        softly.assertThat(product.getTotalPrice()).isEqualTo(popUpCartPage.getProductSubtotalPrice());
        softly.assertThat(product.getQuantity()).hasToString(popUpCartPage.getCartCounterText());

        softly.assertAll();

    }

    @Test
    @Tag("Basket")
    @DisplayName("Basket Calculation")
    public void basketShouldContainAddedProducts() {

        Cart expectedCart = new Cart();

        for (int i = 0; i < Integer.parseInt(System.getProperty("numberOfProductsAddedToCart")); i++) {
            productGridPage.clickOnRandomProduct();

            productDetailsPage.setRandomQuantity();

            expectedCart.addProduct(productDetailsPage.saveProductDetails());

            productDetailsPage.addProductToCart();
            popUpCartPage.continueShopping();

            topMenuPage.navigateToHomePage();
        }

        topMenuPage.goToCartPage();

        Cart actualCart = cartPage.toCart();

        assertThat(actualCart).usingRecursiveComparison().isEqualTo(expectedCart);
    }

}
