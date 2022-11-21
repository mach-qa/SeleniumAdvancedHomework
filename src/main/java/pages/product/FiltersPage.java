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

    public void moveLeftSliderHandle() {
        Double requestedPrice = Double.valueOf(System.getProperty("minimumFilterPrice"));

        move.clickAndHold(leftSliderHandle).perform();
        while (!Objects.equals(getMinimumPrice(), requestedPrice)) {
            move.moveByOffset(((getSliderWidthSize() * 5) / 100), 0).perform();
        }
        move.release().perform();
        waitForSpinner();
    }

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    private WebElement rightSliderHandle;

    public void moveRightSliderHandle() {
        Double requestedPrice = Double.valueOf(System.getProperty("maximumFilterPrice"));
        move.clickAndHold(rightSliderHandle);
        while (!Objects.equals(getMaximumPrice(), requestedPrice)) {
            move.moveByOffset(((getSliderWidthSize() * (-5)) / 100), 0).perform();
        }
        move.release().perform();
        waitForSpinner();
    }

    @FindBy(css = "[data-slider-label] p")
    private WebElement priceRangeText;

    public Double getMinimumPrice() {
        return getPriceFromFilter(priceRangeText, 0);
    }

    public Double getMaximumPrice() {
        return getPriceFromFilter(priceRangeText, 1);
    }

    @FindBy(css = ".ui-slider-horizontal")
    private WebElement priceFilterSlider;

    public int getSliderWidthSize() {
        return priceFilterSlider.getSize().getWidth();
    }

    @FindBy(css = "spinner")
    private WebElement spinner;

    public void waitForSpinner() {
        waitUntilDisappear(spinner);
    }
}
