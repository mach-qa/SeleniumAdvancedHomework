package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ModalDialogPage extends BasePage {

    public ModalDialogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".modal-body .btn-primary")
    private WebElement proceedToCheckoutBtn;

    public void navigateToCart() {
        proceedToCheckoutBtn.click();
    }

    public void waitForProceedBtn() {
        waitToBeVisible(proceedToCheckoutBtn);
    }

    @FindBy(css = ".modal-body .btn-secondary")
    private WebElement continueShoppingBtn;

    public void continueShopping() {
        continueShoppingBtn.click();
    }

    public void waitForContinueShoppingBtn() {
        waitToBeVisible(continueShoppingBtn);
    }

    @FindBy(css = ".modal-body .product-name")
    private WebElement modalAddedProductTitle;

    public String getAddedProductTitle() {
        return modalAddedProductTitle.getText();
    }

    @FindBy(css = ".modal-body .product-price")
    private WebElement modalAddedProductPrice;

    public Double getAddedProductPrice() {
        return getPrice(modalAddedProductPrice);
    }

    @FindBy(css = ".modal-body .subtotal")
    private WebElement modalAddedProductSubtotal;

    public Double getAddedProductSubtotalPrice() {
        return getPrice(modalAddedProductSubtotal);
    }

    @FindBy(css = ".modal-body .cart-products-count")
    private WebElement cartCounterLabel;

    public String getCartCounterText() {
        return cartCounterLabel.getText();
    }
}
