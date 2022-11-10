package base;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.interactions.Actions;
import pages.menu.TopMenuPage;
import pages.product.FiltersPage;
import pages.product.ProductGridPage;
import pages.search.SearchResultPage;

public class Pages extends BaseTest {

    public ProductGridPage productGridPage;
    public TopMenuPage topMenuPage;
    public SearchResultPage searchResultsPage;
    public FiltersPage filterPage;
    public SoftAssertions softly;

    public Actions action;

    @BeforeEach
    public void setPagesComponent() {
        productGridPage = new ProductGridPage(driver);
        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultPage(driver);
        filterPage = new FiltersPage(driver);
        softly = new SoftAssertions();
        action = new Actions(driver);
    }
}
