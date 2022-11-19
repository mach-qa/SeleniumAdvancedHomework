package pages.base;

import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import providers.UserFactory;

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

    //Select Features
    public Select selectForWebElement (WebElement element) {
        return new Select(element);
    }

    public void selectRequestedValue (WebElement element, String value) {
        selectForWebElement(element).selectByValue(value);
    }

    //Random
    public int randomNumber(int range) {
        return random.nextInt(range);
    }

    //Features for List Type
    public int sizeOfList(List<WebElement> element) {
        return element.size();
    }

    public WebElement randomPositionFromList(List<WebElement> element) {
        int sizeOfList = sizeOfList(element);
        return element.get(randomNumber(sizeOfList));
    }

    public boolean compareProductsInList(List<WebElement> element) {
        boolean loopResult = true;
        for (WebElement product : element) {
            if (product.getText().contains(System.getProperty("searchInput"))) {
                System.out.println("Product on List: " + product.getText());
            } else loopResult = false;
        }
        return loopResult;
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
