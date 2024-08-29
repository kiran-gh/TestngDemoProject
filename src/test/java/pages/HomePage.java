package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

//    The following are the web elements that are used in home page.
    By hpLogoEle = By.className("website-logo");
    By hpHomeButtonEle = By.xpath("//a[normalize-space()=\"Home\"]");
    By hpProductsButtonEle = By.xpath("//a[normalize-space()=\"Products\"]");
    By hpCartButtonEle = By.xpath("//a[normalize-space()=\"Cart\"]");
    By hpLogoutButtonEle = By.className("logout-desktop-btn");
    By hpHeadingEle = By.className("home-heading");
    By hpShopNowButtonEle = By.className("shop-now-button");

//    The following is the constructor created for home page
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
//    The following are the methods created in home page and further used in home page test

//    The following method returns the src attribute value of home page
    public String hpLogo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpHomeButtonEle));
        return driver.findElement(hpLogoEle).getAttribute("src");
    }
//    This is the method that returns the current url of home page.
    public String hpUrl() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.getCurrentUrl();
    }
//    This is the method that returns the boolean value of home button element in home page.
    public boolean hpHomeButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpHomeButtonEle));
        return driver.findElement(hpHomeButtonEle).isDisplayed();
    }
//    This is the method that returns the boolean value of products button element in home page.
    public boolean hpProductsButton() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpProductsButtonEle).isDisplayed();
    }
//    This is the method that returns the boolean value of cart button element in home page.
    public boolean hpCartButton() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpCartButtonEle).isDisplayed();
    }
//    This is the method that returns the boolean value of logout button element in home page.
    public boolean hpLogoutButton() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpLogoutButtonEle).isDisplayed();
    }
//    This is the method that return the home page heading
    public String hpHeading() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpHeadingEle).getText();
    }
//    This is the method that returns the products page url after clicking on shop  now button in home page.
    public String hpShopNowButton() {
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        driver.findElement(hpShopNowButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/products"));
        return driver.getCurrentUrl();
    }
//    This is the method that helps in clicking the products button in home page
    public void hpProductsButtonAction() {
        driver.findElement(hpProductsButtonEle).click();
    }
}
