package org.example.lesson5;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ContactUs_linkTest extends BaseTest {
    @Test
    public void contactUs_linkTest() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@title='Contact us']"))
                .click();
        Select select = new Select(getDriver().findElement(By.id("id_contact")));
        select.selectByIndex(1);
        Actions builder = new Actions(getDriver());
        builder
                .sendKeys(getDriver().findElement(By.id("email")), "ulk53043@jiooq.com")
                .sendKeys(getDriver().findElement(By.id("message")), "Message")
                .click(getDriver().findElement(By.id("submitMessage")))
                .perform();

        WebElement webElement5 = getDriver().findElement(By.xpath("//p[@class='alert alert-success']"));
        String text = "Your message has been successfully sent to our team.";
        String actualText = webElement5.getText();
        Assert.assertEquals(actualText, text);

        Thread.sleep(5000l);

    }
}
