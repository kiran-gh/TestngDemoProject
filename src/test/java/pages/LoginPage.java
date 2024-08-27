package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By lpLoginLogoEle = By.className("login-website-logo-desktop-img");
    By lpUserNameInputEle = By.id("username");
    By lpPasswordInputEle = By.id("password");
    By lpLoginButtonEle = By.className("login-button");
    By lpInvalidPasswordErrMsgEle = By.xpath("//p[@class=\"error-message\"]");


    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
    public String lpLoginLogo(){
        return driver.findElement(lpLoginLogoEle).getAttribute("src");
    }

    public void userInputAction(String username, String password){
        driver.findElement(lpUserNameInputEle).sendKeys(username);
        driver.findElement(lpPasswordInputEle).sendKeys(password);
        driver.findElement(lpLoginButtonEle).click();
    }

    public String lpValidLogin(String scenario, String username, String password){
        userInputAction(username,password);
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.getCurrentUrl();
    }

    public String lpInvalidUserNameErrMsg(String scenario, String username, String password) {
        userInputAction(username,password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }

    public String lpInvalidPasswordErrMsg(String scenario, String username, String password) {
        userInputAction(username,password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }

    public String lpEmptyCredentialsErrMsg(String scenario, String username, String password) {
        userInputAction(username,password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }

    public String lpInvalidCredentialsErrMsg(String scenario, String username, String password){
        userInputAction(username,password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }

}
