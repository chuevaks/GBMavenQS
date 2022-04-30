package org.example.lesson6;

import lesson6.MainPage;
import lesson6.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class SearchTest extends BaseTest {
    @Test
    public void searchTest() {
        MainPage mainPage = getMainPage();
        SearchResultPage searchResultPage = mainPage.search("blouse");
        String expectedText = "1 result has been found.";
        String actualText = searchResultPage.readHeadingCounter();
        Assertions.assertEquals(expectedText, actualText);

    }
}
