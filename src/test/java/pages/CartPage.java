package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

//    The following are the web elements that are used in cart page.
    By cpTotalCartItemsEle = By.xpath("(//span[@class=\"cart-count-badge\"])[1]");
    By cpLogoutButtonEle = By.className("logout-desktop-btn");
    By cpHeadingEle = By.className("cart-heading");
    By cpRemoveAllButtonEle = By.className("remove-all-btn");
    By cpCartItemsListEle = By.xpath("//ul[@class=\"cart-list\"]//li");
    By cpRemoveItemButtonEle = By.className("delete-button");
    By cpCartEmptyHeadingEle = By.className("cart-empty-heading");
    By cpDecreaseItemsButtonEle = By.xpath("(//button[@testid=\"minus\"])[1]");
    By cpIncreaseItemsButtonEle = By.xpath("(//button[@testid=\"plus\"])[1]");
    By cpCartTotalPriceOfAnItemEle = By.className("cart-total-price");
    By cpTotalValueOfAllListItemsEle = By.className("order-total-value");

//    The following is the constructor created for cart page
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
//    The following are the methods created in cart page and further used in cart page test

//    This is the method that returns cart count in cart page.
    public String cpCartCount() {
        return driver.findElement(cpTotalCartItemsEle).getText();
    }
//    This is the method that clicks on logout button in cart page.
    public String cpLogoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpLogoutButtonEle));
        driver.findElement(cpLogoutButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/login"));
        return driver.getCurrentUrl();
    }
//    This is the method that returns the cart page heading.
    public String cpHeading() {
        return driver.findElement(cpHeadingEle).getText();
    }
//    This is the method that returns total cart items in cart page.
    public int cpTotalCartItems() {
        List<WebElement> totalListItems = driver.findElements(cpCartItemsListEle);
        return totalListItems.size();
    }
//    This is the method that clears all the list items in cart page.
    public String cpClearAllItems() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpRemoveAllButtonEle));
        driver.findElement(cpRemoveAllButtonEle).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpCartEmptyHeadingEle));
        return driver.findElement(cpCartEmptyHeadingEle).getText();
    }
//    This is the method that removes single item from the list in cart page.
    public void cpRemoveItemButton() {
        driver.findElement(cpRemoveItemButtonEle).click();
    }
//    This is the method that decreases the selected items inside the cart page.
    public boolean cpDecreaseItemsButton() {
        String initalValueBeforeDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] initialArray = initalValueBeforeDecreasing.split(" ");
        String[] initialAmount = initialArray[1].split("/-");
        int initialValue = Integer.parseInt(initialAmount[0]);
        driver.findElement(cpDecreaseItemsButtonEle).click();
        String finalValueAfterDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] finalArray = finalValueAfterDecreasing.split(" ");
        String[] finalAmount = finalArray[1].split("/-");
        int finalValue = Integer.parseInt(finalAmount[0]);
        Assert.assertNotEquals(initialValue, finalValue, "Decrease amount not working as expected");
        return true;
    }
//    This is the method that increases the selected items inside the cart page.
    public boolean cpIncreaseItemsButton() {
        String initalValueBeforeDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] initialArray = initalValueBeforeDecreasing.split(" ");
        String[] initialAmount = initialArray[1].split("/-");
        int initialValue = Integer.parseInt(initialAmount[0]);
        driver.findElement(cpIncreaseItemsButtonEle).click();
        String finalValueAfterDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] finalArray = finalValueAfterDecreasing.split(" ");
        String[] finalAmount = finalArray[1].split("/-");
        int finalValue = Integer.parseInt(finalAmount[0]);
        Assert.assertNotEquals(initialValue, finalValue, "Decrease amount not working as expected");
        return true;
    }
//    This is the method that returns the total sum of all list of items in cart page.
    public String cpSumOfAllItemsDisplaying() {
        String totalValueOfAllItemsDisplaying;
        return totalValueOfAllItemsDisplaying = driver.findElement(cpTotalValueOfAllListItemsEle).getText();
    }
//    This is the method that returns the total value of each and every item.
    public String cpTotalValueOfAllItems() {
        int sum = 0;
        List<WebElement> itemValues = driver.findElements(By.xpath("//p[@class=\"cart-total-price\"]"));
        for (WebElement itemValue : itemValues) {
            String itemValueDisplaying = itemValue.getText();
            String[] finalItemValueDisplaying = itemValueDisplaying.split(" ");
            String[] finalAmount = finalItemValueDisplaying[1].split("/-");
            sum = sum + Integer.parseInt(finalAmount[0]);
        }
        return Integer.toString(sum);
    }


}
