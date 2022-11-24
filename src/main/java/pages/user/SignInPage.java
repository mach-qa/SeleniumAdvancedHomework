package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import providers.UserFactory;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#login-form input[name=\"email\"]")
    private WebElement emailInputField;

    @FindBy(css = "#login-form input[name=\"password\"]")
    private WebElement passwordInputField;

    @FindBy(css = "#submit-login")
    private WebElement signInBtn;

    public SignInPage loginAsRegisteredUser(User registeredUser){
        sendKeys(emailInputField, registeredUser.getUserEmail());
        sendKeys(passwordInputField, registeredUser.getUserPassword());
        signInBtn.click();
        return this;
    }

}
