package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="#order-history td:nth-child(1)")
    private WebElement orderDate;

    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddress;

    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddress;

    @FindBy(css = ".line-total > td:last-child")
    private WebElement totalPrice;

    @FindBy(css = "td span.label-pill")
    private WebElement statusLabel;

    public String getOrderDate() {
        return orderDate.getText();
    }

    public String getOrderDeliveryAddress () {
        return deliveryAddress.getText();
    }

    public String getOrderInvoiceAddress () {
        return invoiceAddress.getText();
    }

    public Double getOrderTotalPrice() {
        return getPrice(totalPrice);
    }

    public String getOrderStatusLabel() {
        return statusLabel.getText();
    }
}