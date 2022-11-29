package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.Objects;

public class FiltersPage extends BasePage {

    public FiltersPage(WebDriver driver) {
        super(driver);
    }

    Actions move = new Actions(driver);

    @FindBy(css = ".faceted-slider")
    private WebElement sliderBox;

    @FindBy(css = "a.ui-slider-handle:nth-child(2)")
    private WebElement leftSliderHandle;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    private WebElement rightSliderHandle;

    @FindBy(css = "[data-slider-label] p")
    private WebElement priceRangeText;

    @FindBy(css = ".ui-slider-horizontal")
    private WebElement priceFilterSlider;

    @FindBy(css = "spinner")
    private WebElement spinner;

    public FiltersPage moveLeftSliderHandle() {
        moveSlider(leftSliderHandle, System.getProperty("minimumFilterPrice"));
        return this;
    }

    public FiltersPage moveRightSliderHandle() {
        moveSlider(rightSliderHandle, System.getProperty("maximumFilterPrice"));
        return this;
    }

    private void moveSlider(WebElement element, String targetPrice) {
        Double requestedPrice = Double.valueOf(targetPrice);
        move.clickAndHold(element);
        while (!Objects.equals(returnMaxMinPrice(element), requestedPrice)) {
            if (returnMaxMinPrice(element) > requestedPrice) {
            move.moveByOffset(((getSliderWidthSize() * (-5)) / 100), 0).perform();}
            else {
                move.moveByOffset(((getSliderWidthSize() * 5) / 100), 0).perform();
            }
        }
        move.release().perform();
        waitForSpinner();
    }

    private Double returnMaxMinPrice(WebElement element) {
        Double price;
        return price = (element.equals(leftSliderHandle)) ? getMinimumPrice() : getMaximumPrice();
    }

    public Double getMinimumPrice() {
        return getPriceFromFilter(priceRangeText, 0);
    }

    public Double getMaximumPrice() {
        return getPriceFromFilter(priceRangeText, 1);
    }

    public int getSliderWidthSize() {
        return priceFilterSlider.getSize().getWidth();
    }

    public FiltersPage waitForSpinner() {
        waitUntilDisappear(spinner);
        return this;
    }
}