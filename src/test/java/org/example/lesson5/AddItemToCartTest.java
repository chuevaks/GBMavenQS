package org.example.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class AddItemToCartTest extends  BaseTest{
    @Test
    public void addItemToCartTest() throws InterruptedException{
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

    }
}
