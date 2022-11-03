package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))));
        random = new Random();
    }

    public WebDriver driver;
    public Actions actions;
    public WebDriverWait wait;
    public Random random;

    public void sendKeys(WebElement element, String textToSet) {
        element.sendKeys(textToSet);
    }
    public void sendKeysAndClear(WebElement element, String textToSet) {
        element.clear();
        sendKeys(element, textToSet);
    }

    public int sizeOfList (List<WebElement> element) {
        return element.size();
    }

    public WebElement randomPositionFromList (List<WebElement> element) {
        int sizeOfList = sizeOfList(element);
        return element.get(random.nextInt(sizeOfList));
    }

    public double getPrice(WebElement element) {
        return Double.parseDouble(element.getText().replace("$",""));
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean compareProductsInList(List<WebElement> element) {
        for (WebElement product : element) {
            if (product.getText().contains(System.getProperty("searchInput"))) {
                System.out.println("Product on List: " + product.getText());
                continue;
            } else return false;
        }
        return true;
    }
}
