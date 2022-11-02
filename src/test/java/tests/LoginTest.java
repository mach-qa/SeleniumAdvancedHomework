package tests;

import org.junit.jupiter.api.Test;
import pages.LoginPage;
import setup.BaseTest;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void shouldLogin () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(System.getProperty("user"), System.getProperty("password"));

        HomePage homePage = new HomePage(driver);

        assertThat(homePage.getUserName()).isEqualTo(System.getProperty("user"));
    }
}
