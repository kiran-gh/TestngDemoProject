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

    public CartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    By cpTotalCartItemsEle = By.xpath("(//span[@class=\"cart-count-badge\"])[1]");
    By cpLogoutButtonEle = By.className("logout-desktop-btn");
    By cpHeadingEle = By.className("cart-heading");
    By cpRemoveAllButtonEle = By.className("remove-all-btn");

    By cpCartItemsListEle = By.xpath("//ul[@class=\"cart-list\"]//li");
    By cpRemoveItemButtonEle = By.className("delete-button");
    By cpCartEmptyHeadingEle = By.className("cart-empty-heading");
    By cpDecreaseItemsButtonEle = By.xpath("(//button[@testid=\"minus\"])[1]");
    By cpIncreaseItemsButtonEle =By.xpath("(//button[@testid=\"plus\"])[1]");
    By cpCartTotalPriceOfAnItemEle = By.className("cart-total-price");
    By cpTotalValueOfAllListItemsEle = By.className("order-total-value");

    public String cpCartCount(){
        return driver.findElement(cpTotalCartItemsEle).getText();
    }

    public String cpLogoutButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpLogoutButtonEle));
        driver.findElement(cpLogoutButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/login"));
        return driver.getCurrentUrl();
    }

    public String cpHeading(){
        return driver.findElement(cpHeadingEle).getText();
    }

    public int cpTotalCartItems(){
        List<WebElement> totalListItems = driver.findElements(cpCartItemsListEle);
        return totalListItems.size();
    }

    public String cpClearAllItems(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpRemoveAllButtonEle));
        driver.findElement(cpRemoveAllButtonEle).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cpCartEmptyHeadingEle));
        return driver.findElement(cpCartEmptyHeadingEle).getText();
    }

    public void cpRemoveItemButton(){
          driver.findElement(cpRemoveItemButtonEle).click();

    }

    public boolean cpDecreaseItemsButton(){
        String initalValueBeforeDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] initialArray =  initalValueBeforeDecreasing.split(" ");
        String[] initialAmount = initialArray[1].split("/-");
        int initialValue = Integer.parseInt(initialAmount[0]);
        driver.findElement(cpDecreaseItemsButtonEle).click();
        String finalValueAfterDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] finalArray =  finalValueAfterDecreasing.split(" ");
        String[] finalAmount = finalArray[1].split("/-");
        int finalValue = Integer.parseInt(finalAmount[0]);
        Assert.assertNotEquals(initialValue,finalValue,"Decrease amount not working as expected");
        return true;
    }

    public boolean cpIncreaseItemsButton(){
        String initalValueBeforeDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] initialArray =  initalValueBeforeDecreasing.split(" ");
        String[] initialAmount = initialArray[1].split("/-");
        int initialValue = Integer.parseInt(initialAmount[0]);
        driver.findElement(cpIncreaseItemsButtonEle).click();
        String finalValueAfterDecreasing = driver.findElement(cpCartTotalPriceOfAnItemEle).getText();
        String[] finalArray =  finalValueAfterDecreasing.split(" ");
        String[] finalAmount = finalArray[1].split("/-");
        int finalValue = Integer.parseInt(finalAmount[0]);
        Assert.assertNotEquals(initialValue,finalValue,"Decrease amount not working as expected");
        return true;
    }
    public String cpSumOfAllItemsDisplaying(){
        String totalValueOfAllItemsDisplaying;
        return totalValueOfAllItemsDisplaying = driver.findElement(cpTotalValueOfAllListItemsEle).getText();
//        String[] finalValueDisplaying =  totalValueOfAllItemsDisplaying.split("Order Total: Rs ");
//        String[] finalTotalAmount = finalValueDisplaying[1].split("/-");
//        return Integer.parseInt(finalTotalAmount[0]);
    }

    public String cpTotalValueOfAllItems(){
        int sum = 0;
        List<WebElement> itemValues = driver.findElements(By.xpath("//p[@class=\"cart-total-price\"]"));
        for(WebElement itemValue: itemValues){
            String itemValueDisplaying = itemValue.getText();
            String[] finalItemValueDisplaying =  itemValueDisplaying.split(" ");
            String[] finalAmount = finalItemValueDisplaying[1].split("/-");
            sum = sum + Integer.parseInt(finalAmount[0]);
        }
        return Integer.toString(sum);
    }


}
