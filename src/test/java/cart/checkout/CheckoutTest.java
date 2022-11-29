package cart.checkout;

import base.Pages;
import models.Address;
import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import providers.AddressFactory;
import providers.UserFactory;

public class CheckoutTest extends Pages {

    @Test
    @Tag("Basket")
    @DisplayName("Checkout tests")
    public void orderDetailsShouldBeAsOrdered() {

        Address newAddress = AddressFactory.getRandomUSAddress();
        User registeredUser = UserFactory.getAlreadyRegisteredUser();

        topMenuPage.navigateToSignInPage();
        signInPage.loginAsRegisteredUser(registeredUser);
        topMenuPage.navigateToHomePage();

        productGridPage.showAllAvailableProducts()
                .clickOnRequestedProduct();

        productDetailsPage.addProductToCart();

        popUpCartPage.navigateToCart();

        cartPage.startCheckoutProcess();

        checkoutPage.startAddNewBillingAddressProcess()
                .fillMandatoryFieldsWithRandomDataAndConfirm(newAddress)
                .expandAddressesTab();

        String expectedDeliveryAddress = checkoutPage.getDeliveryAddress();
        String expectedInvoiceAddress = checkoutPage.getInvoiceAddress();

        checkoutPage.confirmAddresses()
                .confirmShippingMethod()
                .chooseFirstPaymentOption()
                .selectTermsAndConditionsCheckbox();

        Double expectedTotalPrice = checkoutPage.getTotalPrice();

        checkoutPage.PlaceAnOrder();
        softly.assertThat(confirmationPage.getConfirmationText()).isEqualTo(System.getProperty("confirmationMessage"));

        String orderNumber = confirmationPage.getOrderNumber();
        topMenuPage.navigateToAccountDetails();

        yourAccountPage.navigateToOrderHistoryPage();

        orderHistoryPage.goToDetailsOfRequestedOrder(orderNumber);

        softly.assertThat(orderDetailsPage.getOrderDeliveryAddress()).isEqualTo(expectedDeliveryAddress);
        softly.assertThat(orderDetailsPage.getOrderInvoiceAddress()).isEqualTo(expectedInvoiceAddress);
        softly.assertThat(orderDetailsPage.getOrderDate()).isEqualTo(dateFormat.format(date));
        softly.assertThat(orderDetailsPage.getOrderTotalPrice()).isEqualTo(expectedTotalPrice);
        softly.assertThat(orderDetailsPage.getOrderStatusLabel()).isEqualTo(System.getProperty("statusLabel"));
        softly.assertAll();
    }
}
