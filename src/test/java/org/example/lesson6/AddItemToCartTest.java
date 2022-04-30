package org.example.lesson6;

import lesson6.CartPage;
import lesson6.ItemPage;
import lesson6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AddItemToCartTest extends BaseTest {
    @Test
    public void addItemToCartTest() {

        MainPage mainPage = getMainPage();
        ItemPage itemPage = mainPage.addBlouseToCart();
        itemPage.closePopUp();
        CartPage cartPage = itemPage.openCart();
        Assertions.assertTrue(cartPage.isPopupPresent());





    }
}
