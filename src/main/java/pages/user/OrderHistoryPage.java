package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

public class OrderHistoryPage extends BasePage {

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "tbody [scope=\"row\"]")
    private List<WebElement> orderNumberList;

    @FindBy(css = "tbody [data-link-action=\"view-order-details\"]")
    private List<WebElement> orderDetailsBtn;

    public OrderHistoryPage goToDetailsOfRequestedOrder(String order) {
        for (int i = 0; i < orderNumberList.size(); i++) {
            if (orderNumberList.get(i).getText().equals(order)) {
                orderDetailsBtn.get(i).click();
            }
        }
        return this;
    }

}
