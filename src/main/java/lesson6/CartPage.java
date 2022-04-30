package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void deleteFromCart(){
        click(By.xpath("//a[@title='Delete']"));
    }

    public boolean isPopupPresent(){
        return isElementPresent(By.xpath("//h2/i[@class='icon-ok']"));
    }
}
