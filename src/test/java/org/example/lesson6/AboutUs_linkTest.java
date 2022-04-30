package org.example.lesson6;

import lesson6.AboutAsPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class AboutUs_linkTest extends BaseTest {
    @Test
    public void aboutUs_linkTest() throws InterruptedException {

        MainPage mainPage = getMainPage();
        AboutAsPage aboutAsPage = mainPage.goToAboutUaPage();
        String expectedHeading = "ABOUT US";
        String actualHeading = aboutAsPage.readHeading();
        Assertions.assertEquals(expectedHeading, actualHeading);

    }
}
