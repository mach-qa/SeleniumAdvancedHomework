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

    public String getRandomProductText() {
        return randomPositionFromList(allVisibleItems).getText();
    }

    public void clickRandomProduct() {
        randomPositionFromList(allVisibleItems).click();
    }

    public String countProductsOnList() {
        return String.valueOf(sizeOfList(allVisibleItems));
    }

    public List<String> getVisibleProductsName() {
        return stringListOfProducts(allVisibleItems);
    }

    //TODO rozpisac jakoś gdy jest więcej stron i po tym ma probowac poszukać na nastepnej stronie
    public void clickOnRequestedTitle() {
        for (WebElement item : allVisibleItems) {
            if (item.getText().equals(System.getProperty("productForCart"))) {
                item.click();
                break;
            }
        }
    }

    @FindBy(css = "span.price")
    private List<WebElement> allVisibleProductsPrices;

    public Double getVisibleProductsPrices(int i) {
        return getPrice(allVisibleProductsPrices.get(i));
    }

    public int getSizeOfProductPricesList() {
        return sizeOfList(allVisibleProductsPrices);
    }

    @FindBy(css = ".all-product-link")
    private WebElement allProductsBtn;

    public void clickAllProductsBtn() {
        allProductsBtn.click();
    }
}
