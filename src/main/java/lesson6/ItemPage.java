package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public CartPage openCart() {
        click(By.xpath("//a[@title='View my shopping cart']"));
        return new CartPage(getDriver());
    }

    public void closePopUp(){
        click(By.xpath("//span[@title='Close window']"));
    }

}
