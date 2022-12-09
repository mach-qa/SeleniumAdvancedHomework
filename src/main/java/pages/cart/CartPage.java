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
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#cart-subtotal-products span.value")
    private WebElement cartSubtotal;

    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;

    @FindBy(css = "a.btn-primary")
    WebElement proceedToCheckoutBtn;

    private BigDecimal getSumOfProductsCart () {
        return BigDecimal.valueOf(getPrice(cartSubtotal));
    }

    public Cart toCart() {
        return new Cart(saveCartListOfProducts(), getSumOfProductsCart());
    }

    private List<Product> saveCartListOfProducts() {
        return cartItems.stream().map(Product::new).collect(Collectors.toList());
    }

    public CartPage startCheckoutProcess() {
        proceedToCheckoutBtn.click();
        return this;
    }
}
