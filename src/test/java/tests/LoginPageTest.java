package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseClass{
    LoginPage lp;

    @DataProvider(name = "credentials")
    public Object[][] getData(){
        return new Object[][]{
                {"validCredentials","rahul","rahul@2021"},
                {"invalidUserName","rahu","rahul@2021"},
                {"invalidPassword","rahul","rahul@202"},
                {"invalidCredentials","rahu","rahul@202"},
                {"emptyCredentials","",""}
        };
    }

    @BeforeMethod
    public void setup() {
        BaseClass.launchBrowser();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
        lp = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void lpLogoCheck(){
        String actualLogoSrc = lp.lpLoginLogo();
        String expectedLogoSrc = "https://assets.ccbp.in/frontend/react-js/nxt-trendz-logo-img.png";
        Assert.assertEquals(actualLogoSrc, expectedLogoSrc,"Expected logo miss-matched");
    }

    @Test(priority = 2, dataProvider = "credentials")
    public void lpValidLoginCheck(String scenario, String username, String password){
        switch (scenario) {
            case "validCredentials":
                String actualHomePageUrl = lp.lpValidLogin(scenario, username, password);
                String expectedHomePageUrl = "https://rahulnxttrendz.ccbp.tech/";
                Assert.assertEquals(actualHomePageUrl, expectedHomePageUrl, "Home page url miss-match");
                break;
            case "invalidUserName":
                String actualInvalidUserNameErr = lp.lpInvalidUserNameErrMsg(scenario, username, password);
                String expectedInvalidUserNameErr = "*invalid username";
                Assert.assertEquals(actualInvalidUserNameErr, expectedInvalidUserNameErr, "Invalid Username Error message miss-matched");
                break;
            case "invalidPassword":
                String actualInvalidPasswordErr = lp.lpInvalidPasswordErrMsg(scenario, username, password);
                String expectedInvalidPasswordErr = "*username and password didn't match";
                Assert.assertEquals(actualInvalidPasswordErr, expectedInvalidPasswordErr, "Invalid Password Error message miss-matched");
                break;
            case "invalidCredentials":
                String actualInvalidCredentialsErr = lp.lpInvalidCredentialsErrMsg(scenario, username, password);
                String expectedInvalidCredentialsErr = "*invalid username";
                Assert.assertEquals(actualInvalidCredentialsErr, expectedInvalidCredentialsErr, "Invalid Credentials Error message miss-matched");
                break;
            default:
                String actualEmptyCredentialsErr = lp.lpEmptyCredentialsErrMsg(scenario, username, password);
                String expectedEmptyCredentialsErr = "*Username or password is invalid";
                Assert.assertEquals(actualEmptyCredentialsErr, expectedEmptyCredentialsErr, "Invalid Credentials Error message miss-matched");

                break;
        }
    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }





}
