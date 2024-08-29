package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseClass {
    LoginPage lp;
    HomePage hp;

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        return new Object[][]{
                {"validCredentials", "rahul", "rahul@2021"}
        };
    }

    @BeforeMethod
    public void setup() {
        BaseClass.launchBrowser();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        lp = new LoginPage(driver);
        lp.userInputAction("rahul", "rahul@2021");
        hp = new HomePage(driver);

    }

    @Test(priority = 1)
    public void hpLogoCheck() {
        String actualHpLogoUrl = hp.hpLogo();
        String expectedHpLogoUrl = "https://assets.ccbp.in/frontend/react-js/nxt-trendz-logo-img.png";
        Assert.assertEquals(actualHpLogoUrl, expectedHpLogoUrl, "Homepage Logo url miss-match");
    }

    @Test(priority = 2)
    public void hpURLCheck() {
        String actualHpUrl = hp.hpUrl();
        String expectedHpUrl = "https://rahulnxttrendz.ccbp.tech/";
        Assert.assertEquals(actualHpUrl, expectedHpUrl, "Home page url miss-match");
    }

    @Test(priority = 3)
    public void hpHomeButtonCheck() {
        boolean actualHomeButtonPresence = hp.hpHomeButton();
        Assert.assertTrue(actualHomeButtonPresence, "Home button is not displaying");
    }

    @Test(priority = 4)
    public void hpProductsButtonCheck() {
        boolean actualProductsButtonPresence = hp.hpProductsButton();
        Assert.assertTrue(actualProductsButtonPresence, "Products button is not displaying");
    }

    @Test(priority = 5)
    public void hpCartButtonCheck() {
        boolean actualCartButtonPresence = hp.hpCartButton();
        Assert.assertTrue(actualCartButtonPresence, "Cart button is not displaying");
    }

    @Test(priority = 5)
    public void hpLogoutButtonCheck() {
        boolean actualLogoutButtonPresence = hp.hpLogoutButton();
        Assert.assertTrue(actualLogoutButtonPresence, "Logout button is not displaying");
    }

    @Test(priority = 6)
    public void hpHeadingCheck() {
        String actualHpHeading = hp.hpHeading();
        String expectedHpHeading = "Clothes That Get YOU Noticed";
        Assert.assertEquals(actualHpHeading, expectedHpHeading, "Home page heading miss-match");
    }

    @Test(priority = 7)
    public void hpShopNowCheck() {
        String actualProductsPageUrl = hp.hpShopNowButton();
        String expectedProductsPageUrl = "https://rahulnxttrendz.ccbp.tech/products";
        Assert.assertEquals(actualProductsPageUrl, expectedProductsPageUrl, "Products page url miss-match");
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }


}
