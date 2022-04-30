package org.example.lesson6;

import lesson6.ContactUsPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContactUs_linkTest extends BaseTest {
    @Test
    public void contactUs_linkTest() {

        MainPage mainPage = getMainPage();
        ContactUsPage contactUsPage = mainPage.contactUs();
        contactUsPage.sentMessage("ulk53043@jiooq.com", "Message", 1);
        String expectedText = "Your message has been successfully sent to our team.";
        String actualText = contactUsPage.readSuccessMessage();
        Assertions.assertEquals(expectedText, actualText);

    }
}
