package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
    public static WebDriver driver;

    public static void launchBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
