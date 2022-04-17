package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class lesson3_App2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Ссылка "Contact us"

        try {
            driver.get("http://automationpractice.com/");
            WebElement webElement1 = driver.findElement(By.xpath("//a[@title='Contact us']"));
            webElement1.click();
            Select select = new Select(driver.findElement(By.id("id_contact")));
            select.selectByIndex(1);
            WebElement webElement2 = driver.findElement(By.id("email"));
            webElement2.sendKeys("ulk53043@jiooq.com");
            WebElement webElement3 = driver.findElement(By.id("message"));
            webElement3.sendKeys("Message");
            WebElement webElement4 = driver.findElement(By.id("submitMessage"));
            webElement4.click();
            WebElement webElement5 = driver.findElement(By.xpath("//p[@class='alert alert-success']"));
            String text = "Your message has been successfully sent to our team.";
            String actualText = webElement5.getText();
            Assert.assertEquals(actualText, text);
            Thread.sleep(5000l);

        } catch (Exception e) {
            System.out.println("Все сломалось");
        } finally {
            driver.quit();
        }

    }
}
