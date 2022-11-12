package pages.base;

import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasePage {

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait
                (driver, Duration.ofSeconds(Integer.parseInt(System.getProperty("timeout"))));
        random = new Random();
    }

    public WebDriver driver;
    public Actions action;
    public WebDriverWait wait;
    public Random random;



    //SendKeys
    public void sendKeys(WebElement element, String textToSet) {
        element.sendKeys(textToSet);
    }

    public void sendKeysAndClear(WebElement element, String textToSet) {
        element.clear();
        sendKeys(element, textToSet);
    }

    //Features for List Type
    public int sizeOfList(List<WebElement> element) {
        return element.size();
    }

    public WebElement randomPositionFromList(List<WebElement> element) {
        int sizeOfList = sizeOfList(element);
        return element.get(random.nextInt(sizeOfList));
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

    public List<String> stringListOfProducts(List<WebElement> elementList) {
        List<String> productList = new ArrayList<>();
        for (WebElement product : elementList) {
            productList.add(product.getText());
        }
        return productList;
    }

    //GET Features
    public Double getPrice(WebElement element) {
        return Double.parseDouble(element.getText().replace(System.getProperty("currencySymbol"), ""));
    }

    public Double getPriceFromFilter(WebElement element, int i) {
        return Double.parseDouble(element.getText()
                .replace(System.getProperty("currencySymbol"), "")
                .split("-")[i]);
    }

    public String getValue(WebElement element) {
        return element.getAttribute("value");
    }

    //Wait Methods
    public void waitToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilDisappear(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    //Create Object
    public Product createNewProductObject (String productName, Double price, int quantity) {
        return new Product(productName, price, quantity);
    }
}
