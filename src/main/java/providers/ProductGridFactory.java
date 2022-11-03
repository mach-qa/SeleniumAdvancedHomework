package providers;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductGridFactory {

    Random randomGrid = new Random();

    public void randomPositionFromList (List<WebElement> element) {
        int sizeOfList = element.size()-1;
        element.get(randomGrid.nextInt(sizeOfList));
    }

}
