package pages.cart;

import models.Cart;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "span.price")
    private List<WebElement> allCartProductsPrices;

    public Double getVisibleProductsPrices(int i) {
        return getPrice(allCartProductsPrices.get(i));
    }

    @FindBy(css = ".product-price strong")
    private List<WebElement> allCartProductsFullPrice;

    public Double getProductsFullPrice(int i) {
        return getPrice(allCartProductsFullPrice.get(i));
    }

    @FindBy(css = ".cart-items a.label")
    private List<WebElement> allCartProductsTitle;

    private String getVisibleProductsTitle(int i) {
        return allCartProductsTitle.get(i).getText();
    }

    @FindBy(css = "input.form-control")
    private List<WebElement> allCartProductsQuantity;

    private int getVisibleProductsQuantity(int i) {
        return Integer.parseInt(getValue(allCartProductsQuantity.get(i)));
    }

    @FindBy(css = "#cart-subtotal-products span.value")
    private WebElement cartSubtotal;

    private BigDecimal getSumOfProductsCart () {
        return BigDecimal.valueOf(getPrice(cartSubtotal));
    }

    public Cart toCart() {
        return new Cart(saveCartListOfProducts(), getSumOfProductsCart());
    }

    private List<Product> saveCartListOfProducts() {
        List<Product> cartProducts = new ArrayList<>();

        for (int i = 0; i < sizeOfList(allCartProductsTitle); i++) {
            Product cartProduct = createNewProductObject(
                    getVisibleProductsTitle(i),
                    getVisibleProductsPrices(i),
                    getVisibleProductsQuantity(i));
            cartProducts.add(cartProduct);
        }

        return cartProducts;
    }

    @FindBy(css = "a.btn-primary")
    WebElement proceedToCheckoutBtn;

    public void clickProceedToCheckoutBtn() {
        proceedToCheckoutBtn.click();
    }

}
