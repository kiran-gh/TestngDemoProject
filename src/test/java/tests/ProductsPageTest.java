package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsPageTest extends BaseClass{
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
    public void ppHeadingCheck() throws InterruptedException {
        hp.hpShopNowButton();
        String actualPpHeading = pp.ppPrimeDealsHeading();
        String expectedPpHeading = "Exclusive Prime Deals";
        Assert.assertEquals(actualPpHeading,expectedPpHeading,"Prime deals heading miss-match");
    }
    @Test(priority = 2)
    public void ppProductsImageCheck(){
        hp.hpShopNowButton();
        System.out.println(pp.ppProductsSearch());
//        int totalProducts = pp.ppTotalProducts();
//        int totalProductImages = pp.ppProductImages();
//        Assert.assertEquals(totalProducts,totalProductImages,"Product images miss-matching");
    }
    @Test(priority = 3)
    public void ppProductsTitlesCheck(){
        hp.hpShopNowButton();
        int totalProducts = pp.ppTotalProducts();
        int totalProductTitles = pp.ppProductTitles();
        Assert.assertEquals(totalProducts,totalProductTitles,"Product Titles miss-matching");
    }
    @Test(priority = 4)
    public void ppProductsBrandsCheck(){
        hp.hpShopNowButton();
        int totalProducts = pp.ppTotalProducts();
        int totalProductBrands = pp.ppProductBrands();
        Assert.assertEquals(totalProducts,totalProductBrands,"Product Brands miss-matching");
    }
    @Test(priority = 5)
    public void ppProductsPricesCheck(){
        hp.hpShopNowButton();
        int totalProducts = pp.ppTotalProducts();
        int totalProductTitles = pp.ppProductPrices();
        Assert.assertEquals(totalProducts,totalProductTitles,"Product Prices miss-matching");
    }
    @Test(priority = 6)
    public void ppProductsRatingsCheck(){
        hp.hpShopNowButton();
        int totalProducts = pp.ppTotalProducts();
        int totalProductRatings = pp.ppProductRatings();
        Assert.assertEquals(totalProducts,totalProductRatings,"Product Ratings miss-matching");
    }
    @Test(priority = 7)
    public void ppProductsStarsCheck(){
        hp.hpShopNowButton();
        int totalProducts = pp.ppTotalProducts();
        int totalProductStars = pp.ppProductStars();
        Assert.assertEquals(totalProducts,totalProductStars,"Product Stars miss-matching");
    }
    @Test(priority = 8)
    public void ppProductCategoriesCheck(){
        hp.hpShopNowButton();
        int actualProductCategories = pp.ppProductCategories();
        int expectedProductCategories = pp.ppProductCategories();
        Assert.assertEquals(actualProductCategories,expectedProductCategories,"Product Categories miss-matching");
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
