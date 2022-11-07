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

    @FindBy(css = ".product-title")
    private List<WebElement> allVisibleItems;

    public List<WebElement> getListOfVisibleProducts() {
        return allVisibleItems;
    }

    //TODO rozbudować metode o randoma z ProductGridPage
    public String getRandomProductText() {
        return randomPositionFromList(allVisibleItems).getText();
    }

    public String countProductsOnList() {
        return String.valueOf(sizeOfList(allVisibleItems));
    }

    public List<String> getVisibleProductsName() {
        return stringListOfProducts(allVisibleItems);
    }
}
