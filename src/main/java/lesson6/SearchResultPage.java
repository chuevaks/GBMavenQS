package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver){
        super(driver);
    }


    public String readHeadingCounter() {
        return readText(By.xpath("//span[@class='heading-counter']"));
    }
}
