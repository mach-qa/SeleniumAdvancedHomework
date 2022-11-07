package pages.menu;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.product.ProductGridPage;
import pages.search.SearchResultPage;

import javax.swing.*;
import java.util.List;

public class TopMenuPage extends BasePage {

    private JInternalFrame assertThat;

    private void assertThat(boolean contains) {
    }

    ProductGridPage productGridPage = new ProductGridPage(driver);
    SearchResultPage searchResultPage = new SearchResultPage(driver);

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "logo")
    private WebElement logoBtn;

    public void clickOnLogo() {
        logoBtn.click();
    }

    @FindBy(xpath = "//a[@data-depth=0]")
    private List<WebElement> mainCategories;

    public List<WebElement> getMainCategories() {
        return mainCategories;
    }

    @FindBy(css = "#category-3 > a")
    private WebElement clothesCategoryBtn;

    @FindBy(css = "#category-6 > a")
    private WebElement accessoriesCategoryBtn;

    @FindBy(css = "#category-9 > a")
    private WebElement artCategoryBtn;

    public void clickArtCategory() {
        artCategoryBtn.click();
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInputField;

    public void fillSearchInputField(String text) {
        sendKeysAndClear(searchInputField, text);
    }

    @FindBy(css = "button .search")
    private WebElement searchInputBtn;

    public void performSearch() {
        searchInputBtn.click();
    }

    @FindBy(css = "span.product")
    private List<WebElement> productsInDropdown;

    public List<WebElement> getDropDownList() {
        return productsInDropdown;
    }

    public boolean verifyProductsInDropdown() {
        return compareProductsInList(productsInDropdown);
    }

    @FindBy(css = "ul.ui-autocomplete")
    private WebElement dropdownList;

    public void waitForDropdownList() {
        waitToBeVisible(dropdownList);
    }

    @FindBy(css = "a span.hidden-sm-down")
    private WebElement signInBtn;

    @FindBy(css = ".blockcart")
    private WebElement cartBtn;

}
