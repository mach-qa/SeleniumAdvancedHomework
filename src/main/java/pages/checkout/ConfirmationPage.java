package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[contains(text(), 'Order reference')]")
    private WebElement orderReference;

    @FindBy(css = "#content-hook_order_confirmation .card-title")
    private WebElement confirmationText;

    public String getOrderNumber() {
        return orderReference.getText().replace("Order reference: ", "");
    }

    public String getConfirmationText() {
        return confirmationText.getText().replace("\uE876","");
    }
}
