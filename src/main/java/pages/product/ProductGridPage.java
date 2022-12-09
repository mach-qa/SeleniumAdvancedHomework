package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ProductGridPage extends BasePage {

    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-title a")
    private List<WebElement> allVisibleItems;

    @FindBy(css = "span.price")
    private List<WebElement> allVisibleProductsPrices;

    @FindBy(css = ".all-product-link")
    private WebElement allProductsBtn;

    public String getRandomProductText() {
        return randomPositionFromList(allVisibleItems).getText();
    }

    public ProductGridPage clickOnRandomProduct() {
        randomPositionFromList(allVisibleItems).click();
        return this;
    }

    public String getAmountOfProducts() {
        return String.valueOf(allVisibleItems.size());
    }

    public List<String> getVisibleProductsName() {
        return getTextFromElements(allVisibleItems);
    }

    public ProductGridPage clickOnRequestedProduct() {
        allVisibleItems.stream().filter(item -> item.getText()
                .equals(System.getProperty("productForCart")))
                .findFirst()
                .ifPresent(WebElement::click);
        return this;
    }

    public Double getVisibleProductsPrices(int i) {
        return getPrice(allVisibleProductsPrices.get(i));
    }

    public int getAmountOfProductPricesFromList() {
        return allVisibleProductsPrices.size();
    }

    public ProductGridPage showAllAvailableProducts() {
        allProductsBtn.click();
        return this;
    }
}
