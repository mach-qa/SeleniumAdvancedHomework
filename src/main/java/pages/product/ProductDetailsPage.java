package pages.product;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    public void addProductToCart() {
        addToCartBtn.click();
    }

    @FindBy(css = ".modal-body .btn-primary")
    private WebElement proceedToCheckoutBtn;

    public void navigateToCart() {
        proceedToCheckoutBtn.click();
    }

    @FindBy(css = "h1[itemprop=\"name\"]")
    private WebElement productTitle;

    public String getProductTitle() {
        return productTitle.getText();
    }

    @FindBy(css = "input#quantity_wanted")
    private WebElement quantityInput;

    public int getCurrentQuantity() {
        return Integer.parseInt(getValue(quantityInput));
    }

    public void setNewQuantity() {
        sendKeysAndClear(quantityInput, System.getProperty("quantityForProduct"));
    }

    public void setRandomQuantity() {
        sendKeysAndClear(quantityInput, String.valueOf(randomNumber
                (Integer.parseInt(System.getProperty("rangeOfQuantity")))));
    }

    public void waitForQuantityInput() {
        waitToBeVisible(quantityInput);
    }

    @FindBy(css = "span[itemprop=\"price\"]")
    private WebElement productPrice;

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public Product saveProductDetails() {
        return createNewProductObject(getProductTitle(), getProductPrice(), getCurrentQuantity());
    }
}
