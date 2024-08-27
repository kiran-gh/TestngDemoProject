package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    By ppPrimeDealsHeadingEle = By.xpath("//h1[@class=\"primedeals-list-heading\"]");
    By ppProductItemsEle = By.xpath("//li[@class=\"product-item\"]");
    By ppProductImageEle = By.xpath("//li[@class=\"product-item\"]//img[@alt=\"product\"]");
    By ppProductTitleEle = By.xpath("//li[@class=\"product-item\"]//h1[@class=\"title\"]");
    By ppProductBrandEle = By.xpath("//li[@class=\"product-item\"]//p[@class=\"brand\"]");
    By ppProductPriceEle = By.xpath("//li[@class=\"product-item\"]//p[@class=\"price\"]");
    By ppProductRatingELe = By.xpath("//li[@class=\"product-item\"]//p[@class=\"rating\"]");
    By ppProductStarEle = By.xpath("//li[@class=\"product-item\"]//img[@alt=\"star\"]");
    By ppProductsCategoryEle = By.className("category-item");
    By ppProductsSearchEle = By.className("search-input");
    By ppSearchedProductsListEle = By.xpath("//div[@class=\"all-products-container\"]//li");
    By ppSearchIconEle = By.className("search-icon");

    public String ppPrimeDealsHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppPrimeDealsHeadingEle));
        return driver.findElement(ppPrimeDealsHeadingEle).getText();
    }

    public int ppTotalProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductItemsEle));
        List<WebElement> productItems = driver.findElements(ppProductItemsEle);
        return productItems.size();

    }

    public int ppProductImages() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductImageEle));
        List<WebElement> productImages = driver.findElements(ppProductImageEle);
        for(WebElement productImg: productImages){
            boolean productImgStatus = productImg.isDisplayed();
            Assert.assertTrue(productImgStatus,"Product image is not displaying");
        }
        List<WebElement> productImgs = driver.findElements(ppProductImageEle);
        return productImgs.size();
    }

    public int ppProductTitles() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductTitleEle));
        List<WebElement> productTitles = driver.findElements(ppProductTitleEle);
        for(WebElement productTitle: productTitles){
            boolean productTitleStatus = productTitle.isDisplayed();
            Assert.assertTrue(productTitleStatus,"Product Title is not displaying");
        }
        List<WebElement> productTtls = driver.findElements(ppProductTitleEle);
        return productTtls.size();
    }

    public int ppProductBrands() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductBrandEle));
        List<WebElement> productBrands = driver.findElements(ppProductBrandEle);
        for(WebElement productBrand: productBrands){
            boolean productBrandStatus = productBrand.isDisplayed();
            Assert.assertTrue(productBrandStatus,"Product Brand is not displaying");
        }
        List<WebElement> productBrnds = driver.findElements(ppProductBrandEle);
        return productBrnds.size();
    }

    public int ppProductPrices() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductPriceEle));
        List<WebElement> productPrices = driver.findElements(ppProductPriceEle);
        for(WebElement productPrice: productPrices){
            boolean productPriceStatus = productPrice.isDisplayed();
            Assert.assertTrue(productPriceStatus,"Product Price is not displaying");
        }
        List<WebElement> productPrics = driver.findElements(ppProductPriceEle);
        return productPrics.size();
    }

    public int ppProductRatings() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductRatingELe));
        List<WebElement> productRatings = driver.findElements(ppProductRatingELe);
        for(WebElement productRating: productRatings){
            boolean productRatingStatus = productRating.isDisplayed();
            Assert.assertTrue(productRatingStatus,"Product Rating is not displaying");
        }
        List<WebElement> productRtngs = driver.findElements(ppProductRatingELe);
        return productRtngs.size();
    }

    public int ppProductStars() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductStarEle));
        List<WebElement> productStars = driver.findElements(ppProductStarEle);
        for(WebElement productStar: productStars){
            boolean productStarStatus = productStar.isDisplayed();
            Assert.assertTrue(productStarStatus,"Product Star is not displaying");
        }
        List<WebElement> productStrs = driver.findElements(ppProductStarEle);
        return productStrs.size();
    }

    public int ppProductCategories(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductsCategoryEle));
        List<WebElement> productCategories = driver.findElements(ppProductStarEle);
        for(WebElement productCategory: productCategories){
            boolean productCategoryStatus = productCategory.isDisplayed();
            Assert.assertTrue(productCategoryStatus,"Product Category is not displaying");
        }
        List<WebElement> productCategrs = driver.findElements(ppProductsCategoryEle);
        return productCategrs.size();
    }

    public void ppProductsSearch() {
        driver.findElement(ppProductsSearchEle).sendKeys("Watch");
        driver.findElement(ppSearchIconEle).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSearchedProductsListEle));

        List<WebElement> productsWithSearchedName = driver.findElements(By.xpath("ppSearchedProductsListEle"));
        for (WebElement productWithSearchedName : productsWithSearchedName) {
            String productName = productWithSearchedName.getText();
        }
    }
}

