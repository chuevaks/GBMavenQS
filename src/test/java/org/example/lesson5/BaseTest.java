package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
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

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    public static WebDriver getDriver() {
        return driver;
    }

}
