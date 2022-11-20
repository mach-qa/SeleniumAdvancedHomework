package pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#order-details li")
    private List<WebElement> orderDetails;

    public String getOrderNumber() {
        String orderNumber = null;
        for (WebElement position : orderDetails){
            if(position.getText().contains("Order reference")) {
                orderNumber = position.getText().replace("Order reference: ", "");
            }
        }
        return orderNumber;
    }

    @FindBy(css = "#content-hook_order_confirmation .card-title")
    private WebElement confirmationText;

    public String getConfirmationText() {
        return confirmationText.getText().replace("\uE876","");
    }
}
