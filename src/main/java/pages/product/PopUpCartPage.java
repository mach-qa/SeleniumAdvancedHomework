package pages.product;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class PopUpCartPage extends BasePage {

    public PopUpCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".modal-body .btn-primary")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".modal-body .btn-secondary")
    private WebElement continueShoppingBtn;

    @FindBy(css = ".modal-body .product-name")
    private WebElement productTitle;

    @FindBy(css = ".modal-body .product-price")
    private WebElement productPrice;

    @FindBy(css = ".modal-body .product-quantity strong")
    private WebElement productQuantity;

    @FindBy(css = ".modal-body .subtotal")
    private WebElement productSubtotal;

    @FindBy(css = ".modal-body .cart-products-count")
    private WebElement cartCounterLabel;

    public PopUpCartPage navigateToCart() {
        waitForProceedBtn();
        proceedToCheckoutBtn.click();
        return this;
    }

    public PopUpCartPage waitForProceedBtn() {
        waitToBeVisible(proceedToCheckoutBtn);
        return this;
    }

    public PopUpCartPage continueShopping() {
        waitForContinueShoppingBtn();
        continueShoppingBtn.click();
        return this;
    }

    public PopUpCartPage waitForContinueShoppingBtn() {
        waitToBeVisible(continueShoppingBtn);
        return this;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(productQuantity.getText());
    }

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public Double getProductSubtotalPrice() {
        return getPrice(productSubtotal);
    }

    public String getCartCounterText() {
        return cartCounterLabel.getText();
    }

    public Product getProduct() {
        waitToBeVisible(productTitle);
        return createNewProductObject(getProductTitle(), getProductPrice(), getProductQuantity());
    }
}
