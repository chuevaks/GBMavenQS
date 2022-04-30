package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public  class BasePage {
    private WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    protected  WebDriver getDriver(){
        return this.driver;
    }

    public void waitVisibility(By elementBy, boolean canBeClicked){
        ExpectedCondition condition = ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy);
        if (canBeClicked) {
            condition = ExpectedConditions.and(
                    condition,
                    ExpectedConditions.elementToBeClickable(elementBy)
            );
        }
        wait.until(condition);
    }

    protected void click(By elementBy) {
        click(elementBy, true);
    }


    protected void click(By elementBy, boolean waitForVisibility) {
        if (waitForVisibility)
            waitVisibility(elementBy, true);
        driver.findElement(elementBy).click();
    }

    protected void sendKeys(By elementBy, String value) {
        waitVisibility(elementBy,true);
        driver.findElement(elementBy).sendKeys(value);
    }


    protected String readText(By elementBy) {
        waitVisibility(elementBy, false);
        return driver.findElement(elementBy).getText();
    }

    protected boolean isElementPresent(By elementBy){
        try {
            return getDriver().findElement(elementBy) != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String readHeading() {
        return readText(By.xpath("//h1[@class='page-heading']"));
    }

    public String readSuccessMessage() {
        return readText(By.xpath("//p[@class='alert alert-success']"));
    }

    public String readWarningMessage() {
        return readText(By.xpath("//p[@class='alert alert-warning']"));
    }


}
