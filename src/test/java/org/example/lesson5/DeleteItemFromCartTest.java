package org.example.lesson5;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class DeleteItemFromCartTest extends BaseTest{
    @Test
    public void deleteItemFromCartTest() throws InterruptedException{
        getDriver().findElement(By.xpath("//a[@title='Women']"))
                .click();
        getDriver().findElement(By.xpath("//input[@value='4']"))
                .click();
        getDriver().findElement(By.xpath("//img[@title='Blouse']"))
                .click();
        getDriver().findElement(By.id("add_to_cart"))
                .click();
        try {
            getDriver().findElement(By.xpath("//h2/i[@class='icon-ok']"));
        }
        catch (NoSuchElementException e){
            System.out.println("//h2/i[@class='icon-ok']  - не найден");
        }
        getDriver().findElement(By.xpath("//span[@title='Close window']"))
                .click();
        getDriver().findElement(By.xpath("//a[@title='View my shopping cart']"))
                .click();
        getDriver().findElement(By.xpath("//a[@title='Delete']"))
                .click();

        ExpectedCondition condition = ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='alert alert-warning']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(60));
        wait.until(condition);
        WebElement we = getDriver().findElement(By.xpath("//p[@class='alert alert-warning']"));

        String text = "Your shopping cart is empty.";
        String actualText = we.getText();
        Assert.assertEquals(actualText, text);
    }
}
