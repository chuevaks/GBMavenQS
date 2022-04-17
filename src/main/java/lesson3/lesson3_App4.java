package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class lesson3_App4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //4. Добаление товара в корзину
        try {
            driver.get("http://automationpractice.com/");

            driver.findElement(By.xpath("//a[@title='Women']"))
                    .click();
            driver.findElement(By.xpath("//input[@value='4']"))
                    .click();
            driver.findElement(By.xpath("//img[@title='Blouse']"))
                    .click();
            driver.findElement(By.id("add_to_cart"))
                    .click();
            try {
                driver.findElement(By.xpath("//h2/i[@class='icon-ok']"));
            }
            catch (NoSuchElementException e){
                System.out.println("//h2/i[@class='icon-ok']  - не найден");
            }

            Thread.sleep(5000l);

        }
        catch (Exception e){
            System.out.println("Все сломалось");
        }
        finally {
            driver.quit();
        }
    }
}


