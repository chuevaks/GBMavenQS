package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest extends BaseTest{
    @Test
    public void searchTest() throws InterruptedException {
        Actions builder = new Actions(getDriver());
        builder
                .sendKeys(getDriver().findElement(By.id("search_query_top")),"blouse")
                .sendKeys(getDriver().findElement(By.id("search_query_top")), Keys.ENTER)
                .perform();

        ExpectedCondition condition = ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='heading-counter']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(condition);
        WebElement we = getDriver().findElement(By.xpath("//span[@class='heading-counter']"));
        String text = "1 result has been found.";
        String actualText = we.getText();
        Assertions.assertEquals(actualText, text);

    }
}
