package pages.menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "logo")
    private WebElement logoBtn;

    public void clickOnLogo() {
        logoBtn.click();
    }

    @FindBy(css = "#category-3 > a")
    private WebElement clothesCategoryBtn;

    @FindBy(css = "#category-6 > a")
    private WebElement accessoriesCategoryBtn;

    @FindBy(css = "#category-9 > a")
    private WebElement artCategoryBtn;

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
