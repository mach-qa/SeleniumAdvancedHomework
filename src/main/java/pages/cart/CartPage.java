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
        List<Product> cartProducts = new ArrayList<>();

        for (WebElement cartItem : cartItems) {
            Product cartProduct = createNewCartProductObject(cartItem);
            cartProducts.add(cartProduct);
        }
        return cartProducts;
    }

    public CartPage startCheckoutProcess() {
        proceedToCheckoutBtn.click();
        return this;
    }
}
