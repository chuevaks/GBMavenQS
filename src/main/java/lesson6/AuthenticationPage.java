package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AuthenticationPage extends BasePage {

    public AuthenticationPage(WebDriver driver){
        super(driver);
    }

    public MainPage logIn(String email, String password) throws Exception{
        sendKeys(By.id("email"),email);
        sendKeys(By.id("passwd"),password);
        click(By.id("SubmitLogin"));
        return new MainPage(getDriver());
    }


}
