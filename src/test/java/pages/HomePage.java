package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }

    By hpLogoEle = By.className("website-logo");
    By hpHomeButtonEle = By.xpath("//a[normalize-space()=\"Home\"]");
    By hpProductsButtonEle = By.xpath("//a[normalize-space()=\"Products\"]");
    By hpCartButtonEle = By.xpath("//a[normalize-space()=\"Cart\"]");
    By hpLogoutButtonEle = By.className("logout-desktop-btn");
    By hpHeadingEle = By.className("home-heading");
    By hpShopNowButtonEle = By.className("shop-now-button");

    public String hpLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpHomeButtonEle));
        return driver.findElement(hpLogoEle).getAttribute("src");
    }

    public String hpUrl(){
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.getCurrentUrl();
    }

    public boolean hpHomeButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(hpHomeButtonEle));
        return driver.findElement(hpHomeButtonEle).isDisplayed();
    }

    public boolean hpProductsButton(){
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpProductsButtonEle).isDisplayed();
    }

    public boolean hpCartButton(){
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpCartButtonEle).isDisplayed();
    }

    public boolean hpLogoutButton(){
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpLogoutButtonEle).isDisplayed();
    }

    public String hpHeading(){
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.findElement(hpHeadingEle).getText();
    }

    public String hpShopNowButton(){
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        driver.findElement(hpShopNowButtonEle).click();
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/products"));
       return driver.getCurrentUrl();
    }

    public void hpProductsButtonAction(){
        driver.findElement(hpProductsButtonEle).click();
    }
}
