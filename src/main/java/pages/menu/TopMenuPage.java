package pages.menu;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//a[@data-depth=0]")
    private List<WebElement> mainCategories;

    @FindBy(css = "#category-3 > a")
    private WebElement clothesCategoryBtn;

    @FindBy(css = "#category-6 > a")
    private WebElement accessoriesCategoryBtn;

    @FindBy(css = "#category-9 > a")
    private WebElement artCategoryBtn;

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInputField;

    @FindBy(css = "button .search")
    private WebElement searchInputBtn;

    @FindBy(css = "span.product")
    private List<WebElement> productsInDropdown;

    @FindBy(css = "ul.ui-autocomplete")
    private WebElement dropdownList;

    @FindBy(css = "a span.hidden-sm-down")
    private WebElement signInBtn;

    @FindBy(css = ".blockcart")
    private WebElement cartBtn;

    @FindBy(css = ".account")
    private WebElement profileBtn;

    public TopMenuPage navigateToHomePage() {
        logoBtn.click();
        return this;
    }

    public WebElement getRequiredMainCategory(int i) {
        return driver.findElements(By.xpath("//a[@data-depth=0]")).get(i);
    }

    public TopMenuPage goToRequiredMainCategory(int i) {
        getRequiredMainCategory(i).click();
        return this;
    }

    public String getRequiredMainCategoryTitle(int i) {
        return getRequiredMainCategory(i).getText();
    }

    public TopMenuPage waitUntilCategoryIsVisible(int i) {
        waitToBeVisible(getRequiredMainCategory(i));
        return this;
    }

    public int countAvailableMainCategories() {
        return mainCategories.size();
    }

    public TopMenuPage goToArtCategory() {
        artCategoryBtn.click();
        return this;
    }

    public TopMenuPage fillSearchInputField(String text) {
        sendKeysAndClear(searchInputField, text);
        waitForDropdownList();
        return this;
    }

    public TopMenuPage performSearch() {
        searchInputBtn.click();
        return this;
    }

    public List<WebElement> getDropDownList() {
        return productsInDropdown;
    }

    public List<String> getSearchResults() {
        return getTextFromElements(productsInDropdown);
    }

    public TopMenuPage waitForDropdownList() {
        waitToBeVisible(dropdownList);
        return this;
    }

    public void navigateToSignInPage() {
        signInBtn.click();
    }

    public void goToCartPage() {
        cartBtn.click();
    }

    public TopMenuPage navigateToAccountDetails() {
        waitForTopMenuProfile();
        profileBtn.click();
        return this;
    }

    public TopMenuPage waitForTopMenuProfile() {
        waitToBeVisible(profileBtn);
        return this;
    }

}
