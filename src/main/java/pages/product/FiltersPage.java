package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class FiltersPage extends BasePage {

    public FiltersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a.ui-slider-handle:nth-child(2)")
    private WebElement leftSliderHandle;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    private WebElement rightSliderHandle;

    @FindBy(css = "[data-slider-label] p")
    private WebElement priceRangeText;

    public String getFilterPriceText () {
        return priceRangeText.getText();
    }

    public void checkFilterSlider () {
        moveFilterSliderToRequestedValue(rightSliderHandle, priceRangeText);
    }

    @FindBy(css = ".ui-slider-horizontal")
    private WebElement priceFilterSlider;

}
