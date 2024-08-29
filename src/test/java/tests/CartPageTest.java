package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartPageTest extends BaseClass {
    LoginPage lp;
    HomePage hp;
    ProductsPage pp;
    ProductsPageTest ppt;
    CartPage cp;

    @BeforeMethod
    public void setup() {
        BaseClass.launchBrowser();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        lp = new LoginPage(driver);
        lp.userInputAction("rahul", "rahul@2021");
        hp = new HomePage(driver);
        hp.hpShopNowButton();
        pp = new ProductsPage(driver);
        pp.navigateToCartPage();
        ppt = new ProductsPageTest();
        cp = new CartPage(driver);
    }

    @Test(priority = 1)
    public void cpHeadingCheck() {
        Assert.assertEquals(cp.cpHeading(), "My Cart", "Cart page heading miss-match");
    }

    @Test(priority = 2)
    public void cpTotalListOfItemsCheck() {
        Assert.assertEquals(cp.cpCartCount(), Integer.toString(cp.cpTotalCartItems()), "Ok");
    }

    @Test(priority = 3)
    public void cpRemoveSingleItemCheck() {
        cp.cpRemoveItemButton();
        cpTotalListOfItemsCheck();
    }

    @Test(priority = 4)
    public void cpDecreaseButtonCheck() {
        Assert.assertTrue(cp.cpDecreaseItemsButton());
    }

    @Test(priority = 5)
    public void cpIncreaseButtonCheck() {
        Assert.assertTrue(cp.cpIncreaseItemsButton());
    }

    @Test(priority = 6)
    public void cpTotalPriceDisplayingVsSumOfAllItemsCheck() {
        String sumOfIndividualItemsInsideList = "Order Total: Rs " + cp.cpTotalValueOfAllItems() + "/-";
        Assert.assertEquals(sumOfIndividualItemsInsideList, cp.cpSumOfAllItemsDisplaying());
    }

    @Test(priority = 7)
    public void cpClearAllItemsCheck() {
        Assert.assertEquals(cp.cpClearAllItems(), "Your Cart Is Empty", "Error in clearing all the items");
    }

    @AfterMethod
    public void TearDown() {
        driver.quit();
    }
}
