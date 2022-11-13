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

    @FindBy(css = "")
    private WebElement continueShoppingBtn;

    public void continueShopping() {
        continueShoppingBtn.click();
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

    @FindBy(css = ".modal-body .product-quantity strong")
    private WebElement modalAddedProductQuantity;

    public int getAddedProductQuantity() {
        return Integer.parseInt(modalAddedProductQuantity.getText());
    }
}
