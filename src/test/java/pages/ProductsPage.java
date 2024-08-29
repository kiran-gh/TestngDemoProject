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
    HomePage hp;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        hp = new HomePage(driver);
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
//    By ppProductsSearchEle = By.className("search-input");
//    By ppSearchedProductsListEle = By.xpath("//div[@class=\"all-products-container\"]//li");
//    By ppSearchIconEle = By.className("search-icon");
    By ppSelectedProductEle = By.xpath("(//a[@class=\"link-item\"])[1]");
    By ppWirelessEarBudsEle = By.xpath("//h1[normalize-space()=\"True Wireless Earbuds\"]");
    By ppQuartzWatchEle = By.xpath("//h1[normalize-space()=\"Privateer Quartz Watch\"]");
    By ppPodcastMicrophoneEle = By.xpath("//h1[normalize-space()=\"Podcast Microphone\"]");
    By ppSlimFitBlazerEle = By.xpath("//h1[normalize-space()=\"Slim Fit Blazer\"]");

    By ppSelectedProductHeadingEle = By.className("product-name");
    By ppSelectedProductPriceEle = By.className("price-details");
    By ppSelectedProductRatingEle = By.className("rating");
    By ppQuantityIncreaseButtonEle = By.xpath("//button[@testid=\"plus\"]");
    By ppAddToCardButtonEle = By.xpath("//button[normalize-space()=\"ADD TO CART\"]");
    By ppCartButtonEle = By.className("cart-count-badge");

    public String ppPrimeDealsHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppPrimeDealsHeadingEle));
        return driver.findElement(ppPrimeDealsHeadingEle).getText();
    }

    public int ppTotalProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductItemsEle));
        List<WebElement> productItems = driver.findElements(ppProductItemsEle);
        return productItems.size();
    }

    public int ppProduct(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            boolean elementStatus = element.isDisplayed();
            Assert.assertTrue(elementStatus, "Element is not displaying");
        }
        return elements.size();
    }

    public int ppProductImages() {
        return ppProduct(ppProductImageEle);
    }

    public int ppProductTitles() {
        return ppProduct(ppProductTitleEle);
    }

    public int ppProductBrands() {
        return ppProduct(ppProductBrandEle);
    }

    public int ppProductPrices() {
        return ppProduct(ppProductPriceEle);
    }

    public int ppProductRatings() {
        return ppProduct(ppProductRatingELe);
    }

    public int ppProductStars() {
        return ppProduct(ppProductStarEle);
    }

    public int ppProductCategories() {
        return ppProduct(ppProductsCategoryEle);
    }

    public void ppClickOnAProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductEle));
        driver.findElement(ppSelectedProductEle).click();
    }
    public void ppClickOnMultipleProducts(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSlimFitBlazerEle));
        addingMultipleProducts(ppSlimFitBlazerEle);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppQuartzWatchEle));
        addingMultipleProducts(ppQuartzWatchEle);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppPodcastMicrophoneEle));
        addingMultipleProducts(ppPodcastMicrophoneEle);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppWirelessEarBudsEle));
        addingMultipleProducts(ppWirelessEarBudsEle);
    }

    public String ppSelectedProductHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductHeadingEle));
        return driver.findElement(ppSelectedProductHeadingEle).getText();
    }

    public String ppSelectedProductPrice() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductPriceEle));
        return driver.findElement(ppSelectedProductPriceEle).getText();
    }

    public String ppSelectedProductRating() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductRatingEle));
        return driver.findElement(ppSelectedProductRatingEle).getText();
    }

    public String ppQuantityIncreaseButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppQuantityIncreaseButtonEle));
        for (int i = 0; i < 4; i++) {
            driver.findElement(ppQuantityIncreaseButtonEle).click();
        }
        return driver.findElement(By.xpath("//p[@class=\"quantity\"]")).getText();
    }

    public void ppAddToCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppAddToCardButtonEle));
        driver.findElement(ppAddToCardButtonEle).click();

    }

    public String ppItemsInCartIcon(){
        WebElement cartElement = driver.findElement(By.xpath("(//span[@class=\"cart-count-badge\"])[1]"));
        wait.until(ExpectedConditions.visibilityOf(cartElement));
        return driver.findElement(By.xpath("(//span[@class=\"cart-count-badge\"])[1]")).getText();
    }

    public String  ppCartButton(){
        driver.findElement(ppCartButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/cart"));
        return driver.getCurrentUrl();
    }

    public void navigateToCartPage(){
//        ppClickOnAProduct();
//        ppQuantityIncreaseButton();
//        ppAddToCart();
//        ppCartButton();
        ppClickOnMultipleProducts();
        ppCartButton();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/cart"));
    }

    public void addingMultipleProducts(By locator){
        driver.findElement(locator).click();
        ppQuantityIncreaseButton();
        ppAddToCart();
        hp.hpProductsButtonAction();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/products"));
    }
}

