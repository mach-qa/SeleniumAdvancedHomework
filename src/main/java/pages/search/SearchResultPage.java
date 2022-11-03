package pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn-unstyle")
    private WebElement sortDropdownBtn;

    @FindBy(css = "button.btn-unstyle")
    private List<WebElement> sortDropdownList;

    @FindBy(css = ".total-products p")
    private WebElement quantityOfFoundProducts;

    public String readAmountOfFoundedProducts() {
        return quantityOfFoundProducts.getText().replaceAll("[^\\d]", "");
    }
}
