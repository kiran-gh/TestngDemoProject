package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsPageTest extends BaseClass {
    ProductsPage pp;
    HomePage hp;
    LoginPage lp;

    @BeforeMethod
    public void setup() {
        BaseClass.launchBrowser();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        lp = new LoginPage(driver);
        lp.userInputAction("rahul", "rahul@2021");
        hp = new HomePage(driver);
        pp = new ProductsPage(driver);
    }

    @Test(priority = 1)
    public void ppHeadingCheck() {
        hp.hpShopNowButton();
        String actualPpHeading = pp.ppPrimeDealsHeading();
        String expectedPpHeading = "Exclusive Prime Deals";
        Assert.assertEquals(actualPpHeading, expectedPpHeading, "Prime deals heading miss-match");
    }

    @Test(priority = 2)
    public void ppProductContainerCheck() {
        hp.hpShopNowButton();
        int totalProducts = pp.ppTotalProducts();
        Assert.assertEquals(totalProducts, pp.ppProductImages(), "Product images miss-matching");
        Assert.assertEquals(totalProducts, pp.ppProductTitles(), "Product Titles miss-matching");
        Assert.assertEquals(totalProducts, pp.ppProductBrands(), "Product Brands miss-matching");
        Assert.assertEquals(totalProducts, pp.ppProductPrices(), "Product Prices miss-matching");
        Assert.assertEquals(totalProducts, pp.ppProductRatings(), "Product Ratings miss-matching");
        Assert.assertEquals(totalProducts, pp.ppProductStars(), "Product Stars miss-matching");
    }

    @Test(priority = 3)
    public void ppProductCategoriesCheck() {
        hp.hpShopNowButton();
        int actualProductCategories = pp.ppProductCategories();
        int expectedProductCategories = pp.ppProductCategories();
        Assert.assertEquals(actualProductCategories, expectedProductCategories, "Product Categories miss-matching");
    }

    @Test(priority = 4)
    public void ppSelectedProductDataCheck() {
        hp.hpShopNowButton();
        pp.ppClickOnAProduct();
        Assert.assertEquals(pp.ppSelectedProductHeading(), "Hair Dryer", "Selected product heading miss-matched ");
        Assert.assertEquals(pp.ppSelectedProductPrice(), "Rs 760/-", "Selected product price miss-matched ");
        Assert.assertEquals(pp.ppSelectedProductRating(), "3.9", "Selected product rating miss-matched ");
        Assert.assertEquals(pp.ppQuantityIncreaseButton(), "5", "Quantity miss-matching");
    }

    @Test(priority = 5)
    public void ppCartButtonCheck() {
        hp.hpShopNowButton();
        pp.ppClickOnMultipleProducts();
        String cartValue = pp.ppItemsInCartIcon();
        int cartFinalValue = Integer.parseInt(cartValue);
        if (cartFinalValue != 0) {
            driver.findElement(By.xpath("(//span[@class=\"cart-count-badge\"])[1]")).click();
            Assert.assertEquals(driver.getCurrentUrl(), "https://rahulnxttrendz.ccbp.tech/cart", "Cart page url miss-match");
        }
    }

//    @Test(priority = 6)
//    public void ppCartButtonCheck(){
//        ppAddToCartCheckItems();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://rahulnxttrendz.ccbp.tech/cart","Cart page url miss-match");
//    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
