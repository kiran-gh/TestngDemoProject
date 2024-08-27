import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {

    @FindBy(className = "login-website-logo-desktop-img")
    WebElement lpLogoEle;

    @FindBy(id = "username")
    WebElement lpUserNameInputEle;

    @FindBy(id = "password")
    WebElement lpPasswordEle;

    @FindBy(className = "login-button")
    WebElement lpLoginButtonEle;

    
}
