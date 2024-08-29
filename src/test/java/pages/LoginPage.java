package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

//    The following are the web elements that are used in login  page.
    By lpLoginLogoEle = By.className("login-website-logo-desktop-img");
    By lpUserNameInputEle = By.id("username");
    By lpPasswordInputEle = By.id("password");
    By lpLoginButtonEle = By.className("login-button");
    By lpInvalidPasswordErrMsgEle = By.xpath("//p[@class=\"error-message\"]");


//      The following is the constructor created for Login page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(35));
    }
//    The following are the methods created in login page and further used in login page test


//    The following method returns the src attribute value of login page
    public String lpLoginLogo() {
        return driver.findElement(lpLoginLogoEle).getAttribute("src");

    }
//    This is the method that performs user input actions and performs click action.
    public void userInputAction(String username, String password) {
        driver.findElement(lpUserNameInputEle).sendKeys(username);
        driver.findElement(lpPasswordInputEle).sendKeys(password);
        driver.findElement(lpLoginButtonEle).click();
    }
//    This is the method that returns the current page url after login with valid credentials.
    public String lpValidLogin(String scenario, String username, String password) {
        userInputAction(username, password);
        wait.until(ExpectedConditions.urlToBe("https://rahulnxttrendz.ccbp.tech/"));
        return driver.getCurrentUrl();
    }
//    This is the method that returns the error message when login with invalid username.
    public String lpInvalidUserNameErrMsg(String scenario, String username, String password) {
        userInputAction(username, password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }
//    This is the method that returns the error message when login with invalid password.
    public String lpInvalidPasswordErrMsg(String scenario, String username, String password) {
        userInputAction(username, password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }
//    This is the method that returns the error message when login with empty credentials.
    public String lpEmptyCredentialsErrMsg(String scenario, String username, String password) {
        userInputAction(username, password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }
//    This is the method that returns the error message when login with invalid credentials.
    public String lpInvalidCredentialsErrMsg(String scenario, String username, String password) {
        userInputAction(username, password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpInvalidPasswordErrMsgEle));
        return driver.findElement(lpInvalidPasswordErrMsgEle).getText();
    }

}
