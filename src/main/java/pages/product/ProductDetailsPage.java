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

    @FindBy(css = "h1[itemprop=\"name\"]")
    private WebElement productTitle;

    @FindBy(css = "input#quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = "span[itemprop=\"price\"]")
    private WebElement productPrice;

    public ProductDetailsPage addProductToCart() {
        addToCartBtn.click();
        return this;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public int getCurrentQuantity() {
        return Integer.parseInt(getValue(quantityInput));
    }

    public ProductDetailsPage setNewQuantity() {
        waitForQuantityInput();
        sendKeysAndClear(quantityInput, System.getProperty("quantityForProduct"));
        return this;
    }

    public ProductDetailsPage setRandomQuantity() {
        waitForQuantityInput();
        sendKeysAndClear(quantityInput, String.valueOf(randomNumber
                (Integer.parseInt(System.getProperty("rangeOfQuantity")))));
        return this;
    }

    public ProductDetailsPage waitForQuantityInput() {
        waitToBeVisible(quantityInput);
        return this;
    }

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public Product saveProductDetails() {
        return createNewProductObject(getProductTitle(), getProductPrice(), getCurrentQuantity());
    }
}
