package base;

import org.junit.jupiter.api.BeforeEach;
import pages.menu.TopMenuPage;
import pages.product.FiltersPage;
import pages.product.ProductGridPage;
import pages.search.SearchResultPage;

public class Pages  extends BaseTest{

    public ProductGridPage productList;
    public TopMenuPage topMenuPage;
    public SearchResultPage searchResultsPage;
    public FiltersPage filterPage;

    @BeforeEach
    public void setPagesComponent(){
        productList = new ProductGridPage(driver);
        topMenuPage = new TopMenuPage(driver);
        searchResultsPage = new SearchResultPage(driver);
        filterPage = new FiltersPage(driver);
    }
}
