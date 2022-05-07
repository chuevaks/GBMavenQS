package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class lesson3_App1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //1. Ссылка "About us"

        try {
            driver.get("http://automationpractice.com/");
            WebElement webElement1 = driver.findElement(By.xpath("//a[@title='About us']"));
            webElement1.click();
            WebElement webElement2 = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));
            String text = "ABOUT US";
            String actualText = webElement2.getText();
            Assertions.assertEquals(actualText, text);
            Thread.sleep(5000l);
        } catch (Exception e) {
            System.out.println("Все сломалось");
        } finally {
            driver.quit();
        }
    }
}
