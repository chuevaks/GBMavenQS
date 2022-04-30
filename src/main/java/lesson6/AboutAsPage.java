package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutAsPage extends BasePage {
    AboutAsPage(WebDriver driver){
        super(driver);
    }

    @Override
    public String readHeading() {
        return readText(By.xpath("//h1[@class='page-heading bottom-indent']"));
    }

}
