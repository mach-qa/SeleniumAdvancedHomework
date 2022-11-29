package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class YourAccountPage extends BasePage {

    public YourAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#history-link")
    private WebElement orderHistoryBtn;

    public YourAccountPage navigateToOrderHistoryPage() {
        orderHistoryBtn.click();
        return this;
    }
}