package cart;

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
        //TODO Poprawić Assercje - dodac sprawdzenie tekstu + Wartość łączna zamówienia
        for (Product product : expectedCart.getCartList()) {
            softly.assertThat(product.getProductName()).isEqualTo(modalDialogPage.getAddedProductTitle());
            softly.assertThat(product.getPrice()).isEqualTo(modalDialogPage.getAddedProductPrice());
            softly.assertThat(product.getTotalPrice()).isEqualTo(modalDialogPage.getAddedProductSubtotalPrice());
            softly.assertThat(product.getQuantity()).hasToString(modalDialogPage.getCartCounterText());
        }
        softly.assertAll();
    }

    @Test
    @Tag("Basket")
    @DisplayName("Basket Calculation")
    public void basketShouldContainProperProducts() {
        //TODO dodać prawdziwą Assercje wg. Zadania domowego
        Cart expectedCart = new Cart();

        for (int i = 0; i < Integer.parseInt(System.getProperty("numberOfProductsAddedToCart")); i++) {
            productGridPage.clickRandomProduct();
            productDetailsPage.waitForQuantityInput();
            productDetailsPage.setRandomQuantity();
            expectedCart.addProduct(productDetailsPage.saveProductDetails());
            productDetailsPage.addProductToCart();
            modalDialogPage.waitForContinueShoppingBtn();
            modalDialogPage.continueShopping();
            topMenuPage.clickOnLogo();
        }
        topMenuPage.clickOnCartBtn();
        Cart actualCart = cartPage.toCart();

        assertThat(actualCart).usingRecursiveComparison().isEqualTo(expectedCart);
    }

}
