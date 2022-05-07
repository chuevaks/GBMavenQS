package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SignInValidCredentialsTest extends BaseTest{
    @Test
    public void signInValidCredentialsTest()throws InterruptedException{
        getDriver().findElement(By.xpath("//a[@title='Log in to your customer account']"))
                .click();
        Actions builder = new Actions(getDriver());
        builder
                .sendKeys(getDriver().findElement(By.id("email")),"ulk53043@jiooq.com")
                .sendKeys(getDriver().findElement(By.id("passwd")), "72Myw8u4ZzzR")
                .click(getDriver().findElement(By.id("SubmitLogin")))
                .perform();

        WebElement we = getDriver().findElement(By.xpath("//a[@title='View my customer account']"));
        String text = "Name LName";
        String actualText = we.getText();
        Assertions.assertEquals(actualText, text);

        getDriver().findElement(By.xpath("//a[@class='logout']"))
                .click();
        WebElement we2 = getDriver().findElement(By.xpath("//h1[@class='page-heading']"));
        String text2 = "AUTHENTICATION";
        String actualText2 = we2.getText();
        Assertions.assertEquals(actualText2, text2);

    }

}
