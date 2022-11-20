package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css ="#order-history td:nth-child(1)")
    private WebElement orderDate;

    public String getOrderDate() {
        return orderDate.getText();
    }

    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddress;

    public String getOrderDeliveryAddress () {
        return deliveryAddress.getText();
    }

    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddress;

    public String getOrderInvoiceAddress () {
        return invoiceAddress.getText();
    }

    @FindBy(css = ".line-total > td:last-child")
    private WebElement totalPrice;

    public Double getOrderTotalPrice() {
        return getPrice(totalPrice);
    }

    @FindBy(css = "td span.label-pill")
    private WebElement statusLabel;

    public String getOrderStatusLabel() {
        return statusLabel.getText();
    }

//    public void waitForStatusLabel() {
//        waitToBeVisible(statusLabel);
//    }
}