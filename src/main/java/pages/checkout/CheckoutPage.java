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

    @FindBy(css = ".form-control[name=\"id_state\"]")
    private WebElement stateDropdown;

    @FindBy(css = ".form-control[name=\"id_country\"]")
    private WebElement countryDropdown;

    @FindBy(css = "button[name=\"confirm-addresses\"]")
    private WebElement confirmAddressBtn;

    public void setNewBillingAddress() {
        sendKeys(addressInputField, newAddress.getAddress());
        sendKeys(cityInputField, newAddress.getCity());
        sendKeys(postcodeInputField, newAddress.getZipPostalCode());
        selectRequestedValue(stateDropdown, System.getProperty("state"));
        selectRequestedValue(countryDropdown, System.getProperty("country"));
        confirmAddressBtn.click();
    }

    @FindBy(css = "button[name=\"confirmDeliveryOption\"]")
    private WebElement confirmDeliveryBtn;

    public void waitForConfirmDeliveryBtn() {
        waitToBeVisible(confirmDeliveryBtn);
    }

    public void clickConfirmDeliveryBtn() {
        confirmDeliveryBtn.click();
    }

    @FindBy(css = "button[name=\"confirmDeliveryOption\"]")
    private List<WebElement> paymentRadios;


//TODO zastanów się czy można nie hardkodować
    public void chooseFirstPaymentOption() {
        paymentRadios.get(0).click();
    }

    @FindBy(css = "#conditions_to_approve\\[terms-and-conditions\\]")
    private WebElement termsAndConditionsCheckbox;

    public void selectTermsAndConditionsCheckbox() {
        if (termsAndConditionsCheckbox.isSelected()) {
            termsAndConditionsCheckbox.click();
        }
    }

    @FindBy(css = "#payment-confirmation [type=submit]")
    private WebElement placeOrderBtn;

    public void clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }


}
