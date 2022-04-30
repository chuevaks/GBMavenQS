package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AuthenticationPage goToAuthenticationPage(){
        click(By.xpath("//a[@title='Log in to your customer account']"));
        return new AuthenticationPage(getDriver());
    }

    public SearchResultPage search(String request){
        sendKeys(By.id("search_query_top"), request);
        click(By.name("submit_search"));
        return new SearchResultPage(getDriver());
    }


    public AuthenticationPage signOut(){
        click(By.xpath("//a[@class='logout']"));
        return  new AuthenticationPage(getDriver());
    }

    public ContactUsPage contactUs(){
        click(By.xpath("//a[@title='Contact us']"));
        return new ContactUsPage(getDriver());
    }

    public AboutAsPage goToAboutUaPage(){
        click(By.xpath("//a[@title='About us']"));
        return new AboutAsPage(getDriver());
    }

    public ItemPage addBlouseToCart(){
        click(By.xpath("//a[@title='Women']"));
        click(By.xpath("//input[@value='4']"), false);
        click(By.xpath("//img[@title='Blouse']"));
        click(By.id("add_to_cart"));
        return new ItemPage(getDriver());
    }


    public String readUserName() {
        return readText(By.xpath("//a[@title='View my customer account']"));
    }
}
