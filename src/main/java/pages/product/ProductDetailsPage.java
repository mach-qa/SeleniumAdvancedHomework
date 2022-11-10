package pages.product;

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

    public void enterQuantityToBuy() {
        sendKeysAndClear(addToCartBtn, System.getProperty("name"));
    }
}
