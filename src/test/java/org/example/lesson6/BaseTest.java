package org.example.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @BeforeEach
    public void goTo() {
        Assertions.assertDoesNotThrow(() -> driver.navigate().to("http://automationpractice.com/"),
                "Страница не доступна");
    }

    @AfterAll
    public static void close() {
      driver.quit();
    }

    public static MainPage getMainPage(){
        return  mainPage;
    }



}
