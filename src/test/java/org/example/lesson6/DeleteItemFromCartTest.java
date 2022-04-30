package org.example.lesson6;

import lesson6.CartPage;
import lesson6.ItemPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class DeleteItemFromCartTest extends BaseTest {
    @Test
    public void deleteItemFromCartTest() {

        MainPage mainPage = getMainPage();
        ItemPage itemPage = mainPage.addBlouseToCart();
        itemPage.closePopUp();
        CartPage cartPage = itemPage.openCart();
        cartPage.deleteFromCart();
        String expectedText = "Your shopping cart is empty.";
        String actualText = cartPage.readWarningMessage();
        Assertions.assertEquals(expectedText, actualText);


    }
}
