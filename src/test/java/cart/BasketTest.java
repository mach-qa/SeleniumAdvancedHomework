package cart;

import base.Pages;
import models.Cart;
import models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.menu.TopMenuPage;

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
            softly.assertThat(product.getQuantity()).isEqualTo(modalDialogPage.getAddedProductQuantity());
        }
        softly.assertAll();
    }

    @Test
    @Tag("Basket")
    @DisplayName("Basket Calculation")
    public void basketShouldContainProperProducts() {
        //TODO dodać prawdziwą Assercje wg. Zadania domowego
        Cart expectedCart = new Cart();

//        for (int i = 0; i < Integer.parseInt(System.getProperty("numberOfProductsAddedToCart")); i++) {
//            productGridPage.clickRandomProduct();
//            productDetailsPage.waitForQuantityInput();
//            productDetailsPage.setRandomQuantity();
//            expectedCart.addProduct(productDetailsPage.saveProductDetails());
//            productDetailsPage.addProductToCart();
//            modalDialogPage.continueShopping();
//            topMenuPage.clickOnLogo();
//        }
//        topMenuPage.clickOnCartBtn();
//        Cart actualCart = cartPage.toCart();

        Product product1 = new Product("Pokemon", 29.99, 4);
        Product product2 = new Product("Bulbasaur", 30.99, 1);


        expectedCart.addProduct(product1);
        expectedCart.addProduct(product2);

        System.out.println(expectedCart);
    }

}
