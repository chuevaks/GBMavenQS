package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class lesson3_App3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //3. Вход с валидным именем пользователя и паролем
        try {
            driver.get("http://automationpractice.com/");
            driver.findElement(By.xpath("//a[@title='Log in to your customer account']"))
                    .click();
            driver.findElement(By.id("email"))
                    .sendKeys("ulk53043@jiooq.com");
            driver.findElement(By.id("passwd"))
                    .sendKeys("72Myw8u4ZzzR");
            driver.findElement(By.id("SubmitLogin"))
                    .click();
            WebElement we = driver.findElement(By.xpath("//a[@title='View my customer account']"));
            String text = "Name LName";
            String actualText = we.getText();
            Assertions.assertEquals(actualText, text);

            driver.findElement(By.xpath("//a[@class='logout']"))
                    .click();
            WebElement we2 = driver.findElement(By.xpath("//h1[@class='page-heading']"));
            String text2 = "AUTHENTICATION";
            String actualText2 = we2.getText();
            Assertions.assertEquals(actualText2, text2);

            Thread.sleep(5000l);

        } catch (Exception e) {
            System.out.println("Все сломалось");
        } finally {
            driver.quit();
        }

    }
}
