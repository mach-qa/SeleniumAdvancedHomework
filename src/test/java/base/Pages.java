package base;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.interactions.Actions;
import pages.cart.CartPage;
import pages.checkout.CheckoutPage;
import pages.checkout.ConfirmationPage;
import pages.menu.TopMenuPage;
import pages.product.FiltersPage;
import pages.product.ModalDialogPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductGridPage;
import pages.search.SearchResultPage;
import pages.user.OrderDetailsPage;
import pages.user.OrderHistoryPage;
import pages.user.SignInPage;
import pages.user.YourAccountPage;

public class Pages extends BaseTest {

    public ProductGridPage productGridPage;
    public TopMenuPage topMenuPage;
    public SearchResultPage searchResultsPage;
    public FiltersPage filterPage;
    public ProductDetailsPage productDetailsPage;
    public ModalDialogPage modalDialogPage;
    public CartPage cartPage;
    public SignInPage signInPage;
    public CheckoutPage checkoutPage;
    public ConfirmationPage confirmationPage;
    public YourAccountPage yourAccountPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderDetailsPage orderDetailsPage;
    public SoftAssertions softly;
    public Actions action;

    @BeforeEach
    public void setPagesComponent() {
        productGridPage = new ProductGridPage(driver);
        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultPage(driver);
        filterPage = new FiltersPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        modalDialogPage = new ModalDialogPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        confirmationPage = new ConfirmationPage(driver);
        yourAccountPage = new YourAccountPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        signInPage = new SignInPage(driver);
        softly = new SoftAssertions();
        action = new Actions(driver);
    }
}
