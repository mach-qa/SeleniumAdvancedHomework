package pages.checkout;

import models.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import providers.AddressFactory;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    Address newAddress = AddressFactory.setNewAddressForRegisteredUser();

    @FindBy(css = "a[data-link-action=\"different-invoice-address\"]")
    private WebElement differentInvoiceAddressBtn;

    @FindBy(css = ".add-address a[href*=\"invoice\"]")
    private WebElement addNewInvoiceAddressBtn;

    public void clickNewBillingAddressBtn() {
        differentInvoiceAddressBtn.click();
        if (isElementPresent(addNewInvoiceAddressBtn)) {
            addNewInvoiceAddressBtn.click();
        }
    }

    @FindBy(css = ".form-control[name=\"address1\"]")
    private WebElement addressInputField;

    public void waitForLoadingInputFields() {
        waitToBeVisible(addressInputField);
    }

    @FindBy(css = ".form-control[name=\"city\"]")
    private WebElement cityInputField;

    @FindBy(css = ".form-control[name=\"postcode\"]")
    private WebElement postcodeInputField;

    @FindBy(css = ".form-control[name=\"id_state\"]")
    private WebElement stateDropdown;

    public void waitForStateDropdown() {
        waitToBeVisible(addressInputField);
    }

    @FindBy(css = ".form-control[name=\"id_country\"]")
    private WebElement countryDropdown;

    @FindBy(css = "button[name=\"confirm-addresses\"]")
    private WebElement confirmAddressBtn;

    public void confirmAddresses() {
        confirmAddressBtn.click();
    }

    public void setNewBillingAddress() {
        sendKeys(addressInputField, newAddress.getAddress());
        sendKeys(cityInputField, newAddress.getCity());
        sendKeys(postcodeInputField, newAddress.getZipPostalCode());
        selectRequestedValue(stateDropdown, System.getProperty("state"));
        selectRequestedValue(countryDropdown, System.getProperty("country"));
        confirmAddresses();
    }

    @FindBy(css = "#delivery-addresses .selected .address")
    private WebElement selectedDeliveryAddress;

    public String getDeliveryAddress() {
        return selectedDeliveryAddress.getText();
    }

    @FindBy(css = "#invoice-addresses .selected .address")
    private WebElement selectedInvoiceAddress;
    public String getInvoiceAddress() {
        return selectedInvoiceAddress.getText();
    }

    @FindBy(css = "#checkout-addresses-step .step-title")
    private WebElement addressesStepTab;

    public void clickAddressesTab() {
        addressesStepTab.click();
    }

    @FindBy(css = "button[name=\"confirmDeliveryOption\"]")
    private WebElement confirmDeliveryBtn;

    public void waitForConfirmDeliveryBtn() {
        waitToBeVisible(confirmDeliveryBtn);
    }

    public void clickConfirmDeliveryBtn() {
        confirmDeliveryBtn.click();
    }

    @FindBy(css = ".payment-option [type=\"radio\"]")
    private List<WebElement> paymentRadios;

    @FindBy(css = ".payment-options label span")
    private List<WebElement> paymentRadiosText;

    public void chooseFirstPaymentOption() {
        for (int i = 0; i < sizeOfList(paymentRadios); i++) {
            if(paymentRadiosText.get(i).getText().equals(System.getProperty("paymentOption"))) {
                paymentRadios.get(i).click();
            }
        }
    }

    @FindBy(css = "#conditions_to_approve\\[terms-and-conditions\\]")
    private WebElement termsAndConditionsCheckbox;

    public void selectTermsAndConditionsCheckbox() {
        if (!termsAndConditionsCheckbox.isSelected()) {
            termsAndConditionsCheckbox.click();
        }
    }

    @FindBy(css = "#payment-confirmation [type=submit]")
    private WebElement placeOrderBtn;

    public void clickPlaceOrderBtn() {
        placeOrderBtn.click();
    }

    @FindBy(css = ".cart-total .value")
    private WebElement totalPrice;

    public Double getTotalPrice() {
        return getPrice(totalPrice);
    }
}
