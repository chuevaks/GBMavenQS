package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AboutUs_linkTest extends BaseTest {
    @Test
    public void aboutUs_linkTest() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[@title='About us']"))
                .click();
        WebElement webElement2 = getDriver().findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));
        String text = "ABOUT US";
        String actualText = webElement2.getText();
        Assertions.assertEquals(actualText, text);
        Thread.sleep(5000l);


    }
}
