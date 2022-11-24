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

    @FindBy(css = ".product-price strong")
    private List<WebElement> allCartProductsFullPrice;

    @FindBy(css = ".cart-items a.label")
    private List<WebElement> allCartProductsTitle;

    @FindBy(css = "input.form-control")
    private List<WebElement> allCartProductsQuantity;

    @FindBy(css = "#cart-subtotal-products span.value")
    private WebElement cartSubtotal;

    @FindBy(css = "a.btn-primary")
    WebElement proceedToCheckoutBtn;

    public Double getVisibleProductsPrices(int i) {
        return getPrice(allCartProductsPrices.get(i));
    }

    public Double getProductsFullPrice(int i) {
        return getPrice(allCartProductsFullPrice.get(i));
    }

    private String getVisibleProductsTitle(int i) {
        return allCartProductsTitle.get(i).getText();
    }

    private int getVisibleProductsQuantity(int i) {
        return Integer.parseInt(getValue(allCartProductsQuantity.get(i)));
    }

    private BigDecimal getSumOfProductsCart () {
        return BigDecimal.valueOf(getPrice(cartSubtotal));
    }

    public Cart toCart() {
        return new Cart(saveCartListOfProducts(), getSumOfProductsCart());
    }

    //TODO Sprawdzić Ostatnie zajęcia z Q&A aby sprawdzić jak nie wykorzystać tylu list w obiektach
    private List<Product> saveCartListOfProducts() {
        List<Product> cartProducts = new ArrayList<>();

        for (int i = 0; i < allCartProductsTitle.size(); i++) {
            Product cartProduct = createNewProductObject(
                    getVisibleProductsTitle(i),
                    getVisibleProductsPrices(i),
                    getVisibleProductsQuantity(i));
            cartProducts.add(cartProduct);
        }
        return cartProducts;
    }

    public CartPage startCheckoutProcess() {
        proceedToCheckoutBtn.click();
        return this;
    }
}
