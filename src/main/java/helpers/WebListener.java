package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebListener extends AbstractWebDriverEventListener {

    private static Logger logger = LoggerFactory.getLogger(WebListener.class);

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("***************** Event listener before click: " + element.getText());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("***************** Event listener after click: " + element.getText());
    }

}
