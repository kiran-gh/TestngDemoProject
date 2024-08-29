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

//    The following are the  web elements that are used in products page.
    By ppPrimeDealsHeadingEle = By.xpath("//h1[@class=\"primedeals-list-heading\"]");
    By ppProductItemsEle = By.xpath("//li[@class=\"product-item\"]");
    By ppProductImageEle = By.xpath("//li[@class=\"product-item\"]//img[@alt=\"product\"]");
    By ppProductTitleEle = By.xpath("//li[@class=\"product-item\"]//h1[@class=\"title\"]");
    By ppProductBrandEle = By.xpath("//li[@class=\"product-item\"]//p[@class=\"brand\"]");
    By ppProductPriceEle = By.xpath("//li[@class=\"product-item\"]//p[@class=\"price\"]");
    By ppProductRatingELe = By.xpath("//li[@class=\"product-item\"]//p[@class=\"rating\"]");
    By ppProductStarEle = By.xpath("//li[@class=\"product-item\"]//img[@alt=\"star\"]");
    By ppProductsCategoryEle = By.className("category-item");
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

//    The following is the constructor created for products page
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
        hp = new HomePage(driver);
    }
//    The following are the methods created in products page and further used in products page test

//    This is the method that returns prime deals heading in products page.
    public String ppPrimeDealsHeading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ppPrimeDealsHeadingEle));
        return driver.findElement(ppPrimeDealsHeadingEle).getText();
    }

//    This is the method that returns the total no of products available in products page
    public int ppTotalProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppProductItemsEle));
        List<WebElement> productItems = driver.findElements(ppProductItemsEle);
        return productItems.size();
    }
//    This is the method that returns the total no of product div sections.
    public int ppProduct(By locator) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            boolean elementStatus = element.isDisplayed();
            Assert.assertTrue(elementStatus, "Element is not displaying");
        }
        return elements.size();
    }
//    This is the method that returns total no of product images in products page.
    public int ppProductImages() {
        return ppProduct(ppProductImageEle);
    }
//    This is the method that returns total no of product titles in products page.
    public int ppProductTitles() {
        return ppProduct(ppProductTitleEle);
    }
//    This is the method that returns total no of product brands in products page.
    public int ppProductBrands() {
        return ppProduct(ppProductBrandEle);
    }
//    This is the method that returns total no of product prices in products page.
    public int ppProductPrices() {
        return ppProduct(ppProductPriceEle);
    }
//    This is the method that returns total no of product ratings in products page.
    public int ppProductRatings() {
        return ppProduct(ppProductRatingELe);
    }
//    This is the method that returns total no of product stars in products page.
    public int ppProductStars() {
        return ppProduct(ppProductStarEle);
    }
//    This is the method that returns total no of product categories in products page.
    public int ppProductCategories() {
        return ppProduct(ppProductsCategoryEle);
    }
//    This is the method that helps in clicking on a product.
    public void ppClickOnAProduct() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductEle));
        driver.findElement(ppSelectedProductEle).click();
    }
//    This is the method that helps in clicking on multiple products
    public void ppClickOnMultipleProducts() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSlimFitBlazerEle));
        addingMultipleProducts(ppSlimFitBlazerEle);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppQuartzWatchEle));
        addingMultipleProducts(ppQuartzWatchEle);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppPodcastMicrophoneEle));
        addingMultipleProducts(ppPodcastMicrophoneEle);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppWirelessEarBudsEle));
        addingMultipleProducts(ppWirelessEarBudsEle);
    }
//    This is the method that returns the selected product heading in products page.
    public String ppSelectedProductHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductHeadingEle));
        return driver.findElement(ppSelectedProductHeadingEle).getText();
    }
//    This is the method that returns the selected product price in products page.
    public String ppSelectedProductPrice() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductPriceEle));
        return driver.findElement(ppSelectedProductPriceEle).getText();
    }
//    This is the method that returns the selected product rating in products page.
    public String ppSelectedProductRating() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppSelectedProductRatingEle));
        return driver.findElement(ppSelectedProductRatingEle).getText();
    }
//    This is the method that helps in increasing the quantity size in products page.
    public String ppQuantityIncreaseButton() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppQuantityIncreaseButtonEle));
        for (int i = 0; i < 4; i++) {
            driver.findElement(ppQuantityIncreaseButtonEle).click();
        }
        return driver.findElement(By.xpath("//p[@class=\"quantity\"]")).getText();
    }
//    This is the method that helps in adding items to cart in products page
    public void ppAddToCart() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ppAddToCardButtonEle));
        driver.findElement(ppAddToCardButtonEle).click();
    }
//    This is the method that returns the total number of list items added to cart, that are displayed in cart icon
    public String ppItemsInCartIcon() {
        WebElement cartElement = driver.findElement(By.xpath("(//span[@class=\"cart-count-badge\"])[1]"));
        wait.until(ExpectedConditions.visibilityOf(cartElement));
        return driver.findElement(By.xpath("(//span[@class=\"cart-count-badge\"])[1]")).getText();
    }
//    This is the method that returns the cart page url after clicking on cart icon in products page
    public String ppCartButton() {
        driver.findElement(ppCartButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/cart"));
        return driver.getCurrentUrl();
    }
//    This is the method that helps in navigating to cart page from products page.
    public void navigateToCartPage() {
        ppClickOnMultipleProducts();
        ppCartButton();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/cart"));
    }
//    This is the method that adds multiple items to cart section in products page
    public void addingMultipleProducts(By locator) {
        driver.findElement(locator).click();
        ppQuantityIncreaseButton();
        ppAddToCart();
        hp.hpProductsButtonAction();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/products"));
    }
}

