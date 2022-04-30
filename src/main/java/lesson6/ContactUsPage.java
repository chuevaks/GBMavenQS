package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends BasePage{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public void sentMessage(String email, String message, int index ){
        Select select = new Select(getDriver().findElement(By.id("id_contact")));
        select.selectByIndex(index);
        sendKeys(By.id("email"),email);
        sendKeys(By.id("message"),message);
        click(By.id("submitMessage"));
    }
}
