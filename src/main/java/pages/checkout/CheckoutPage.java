package pages.checkout;

import models.Address;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import providers.AddressFactory;
import providers.UserFactory;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    Address newAddress = AddressFactory.setNewAddressForRegisteredUser();

    @FindBy(css = "a[data-link-action=\"different-invoice-address\"]")
    private WebElement addNewBillingAddressBtn;

    public void clickNewBillingAddressBtn() {
        addNewBillingAddressBtn.click();
    }

    @FindBy(css = ".form-control[name=\"address1\"]")
    private WebElement addressInputField;

    @FindBy(css = ".form-control[name=\"city\"]")
    private WebElement cityInputField;

    @FindBy(css = ".form-control[name=\"postcode\"]")
    private WebElement postcodeInputField;

    @FindBy(css = ".form-control[name=\"postcode\"]")
    private List<WebElement> stateDropdown;

    @FindBy(css = "button[name=\"confirm-addresses\"]")
    private WebElement confirmAddressBtn;

    public void setNewBillingAddress() {
        sendKeys(addressInputField, newAddress.getAddress());
        sendKeys(cityInputField, newAddress.getCity());
        sendKeys(postcodeInputField, newAddress.getZipPostalCode());
        confirmAddressBtn.click();
    }

}
