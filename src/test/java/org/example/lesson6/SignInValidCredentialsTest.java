package org.example.lesson6;

import lesson6.AuthenticationPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SignInValidCredentialsTest extends BaseTest {
    @Test
    public void signInValidCredentialsTest() throws Exception {

        MainPage mainPage = getMainPage();
        AuthenticationPage authenticationPage = mainPage.goToAuthenticationPage();
        MainPage mainPage1 = authenticationPage.logIn("ulk53043@jiooq.com", "72Myw8u4ZzzR");
        String expectedText = "Name LName";
        String actualText = mainPage1.readUserName();
        Assertions.assertEquals(expectedText, actualText);
        AuthenticationPage authenticationPage1 = mainPage1.signOut();
        String expectedHeading = "AUTHENTICATION";
        String actualHeading = authenticationPage1.readHeading();
        Assertions.assertEquals(expectedHeading, actualHeading);
    }
}
