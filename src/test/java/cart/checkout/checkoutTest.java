package cart.checkout;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class checkoutTest extends Pages {

    @Test
    @Tag("Basket")
    @DisplayName("Checkout tests")
    public void orderDetailsShouldBeAsOrdered() {

        topMenuPage.clickSignInBtn();
        signInPage.loginAsRegisteredUser();
        topMenuPage.clickOnLogo();
        productGridPage.clickAllProductsBtn();
        productGridPage.clickOnRequestedTitle();
        productDetailsPage.addProductToCart();
        modalDialogPage.waitForProceedBtn();
        modalDialogPage.navigateToCart();
        cartPage.clickProceedToCheckoutBtn();
        checkoutPage.clickNewBillingAddressBtn();
        checkoutPage.waitForLoadingInputFields();
        checkoutPage.setNewBillingAddress();
        checkoutPage.clickAddressesTab();

        String expectedDeliveryAddress = checkoutPage.getDeliveryAddress();
        String expectedInvoiceAddress = checkoutPage.getInvoiceAddress();

        checkoutPage.confirmAddresses();
        checkoutPage.waitForConfirmDeliveryBtn();
        checkoutPage.clickConfirmDeliveryBtn();
        checkoutPage.chooseFirstPaymentOption();
        checkoutPage.selectTermsAndConditionsCheckbox();

        Double expectedTotalPrice = checkoutPage.getTotalPrice();
        checkoutPage.clickPlaceOrderBtn();
        softly.assertThat(confirmationPage.getConfirmationText()).isEqualTo(System.getProperty("confirmationMessage"));

        String orderNumber = confirmationPage.getOrderNumber();
        topMenuPage.waitForTopMenuProfile();
        topMenuPage.navigateToAccountDetails();
        yourAccountPage.navigateToOrderHistoryPage();
        orderHistoryPage.clickDetailsOfRequestedOrder(orderNumber);

        softly.assertThat(orderDetailsPage.getOrderDeliveryAddress()).isEqualTo(expectedDeliveryAddress);
        softly.assertThat(orderDetailsPage.getOrderInvoiceAddress()).isEqualTo(expectedInvoiceAddress);
        softly.assertThat(orderDetailsPage.getOrderDate()).isEqualTo(dateFormat.format(date));
        softly.assertThat(orderDetailsPage.getOrderTotalPrice()).isEqualTo(expectedTotalPrice);
        softly.assertThat(orderDetailsPage.getOrderStatusLabel()).isEqualTo(System.getProperty("statusLabel"));
        softly.assertAll();
    }
}
