package pages.checkout;

import models.Address;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-link-action=\"different-invoice-address\"]")
    private WebElement differentInvoiceAddressBtn;

    @FindBy(css = ".add-address a[href*=\"invoice\"]")
    private WebElement addNewInvoiceAddressBtn;

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

    @FindBy(css = "#delivery-addresses .selected .address")
    private WebElement selectedDeliveryAddress;

    @FindBy(css = "#invoice-addresses .selected .address")
    private WebElement selectedInvoiceAddress;

    @FindBy(css = "#checkout-addresses-step .step-title")
    private WebElement addressesStepTab;

    @FindBy(css = "button[name=\"confirmDeliveryOption\"]")
    private WebElement confirmDeliveryBtn;

    @FindBy(css = ".payment-option [type=\"radio\"]")
    private List<WebElement> paymentRadios;

    @FindBy(css = ".payment-options label span")
    private List<WebElement> paymentRadiosText;

    @FindBy(css = "#conditions_to_approve\\[terms-and-conditions\\]")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(css = "#payment-confirmation [type=submit]")
    private WebElement placeOrderBtn;

    @FindBy(css = ".cart-total .value")
    private WebElement totalPrice;

    public CheckoutPage startAddNewBillingAddressProcess() {
        differentInvoiceAddressBtn.click();
        if (isElementPresent(addNewInvoiceAddressBtn)) {
            addNewInvoiceAddressBtn.click();
        }
        return this;
    }

    public CheckoutPage waitForLoadingInputFields() {
        waitToBeVisible(addressInputField);
        return this;
    }

    public CheckoutPage waitForStateDropdown() {
        waitToBeVisible(addressInputField);
        return this;
    }

    public CheckoutPage confirmAddresses() {
        confirmAddressBtn.click();
        return this;
    }

    public CheckoutPage fillMandatoryFieldsWithRandomDataAndConfirm(Address newAddress) {
        waitForLoadingInputFields();
        sendKeys(addressInputField, newAddress.getAddress());
        sendKeys(cityInputField, newAddress.getCity());
        sendKeys(postcodeInputField, newAddress.getZipPostalCode());
        selectRequestedValue(stateDropdown, System.getProperty("state"));
        selectRequestedValue(countryDropdown, System.getProperty("country"));
        confirmAddresses();
        return this;
    }

    public String getDeliveryAddress() {
        return selectedDeliveryAddress.getText();
    }

    public String getInvoiceAddress() {
        return selectedInvoiceAddress.getText();
    }

    public CheckoutPage expandAddressesTab() {
        addressesStepTab.click();
        return this;
    }

    public CheckoutPage waitForConfirmDeliveryBtn() {
        waitToBeVisible(confirmDeliveryBtn);
        return this;
    }

    public CheckoutPage confirmShippingMethod() {
        waitForConfirmDeliveryBtn();
        confirmDeliveryBtn.click();
        return this;
    }

    public CheckoutPage chooseFirstPaymentOption() {
        for (int i = 0; i < paymentRadios.size(); i++) {
            if(paymentRadiosText.get(i).getText().equals(System.getProperty("paymentOption"))) {
                paymentRadios.get(i).click();
            }
        }
        return this;
    }

    public CheckoutPage selectTermsAndConditionsCheckbox() {
        if (!termsAndConditionsCheckbox.isSelected()) {
            termsAndConditionsCheckbox.click();
        }
        return this;
    }

    public CheckoutPage PlaceAnOrder() {
        placeOrderBtn.click();
        return this;
    }

    public Double getTotalPrice() {
        return getPrice(totalPrice);
    }
}
