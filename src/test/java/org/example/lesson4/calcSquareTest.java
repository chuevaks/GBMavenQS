package org.example.lesson4;

import lesson4.Triangle;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class calcSquareTest {

    @Test
    public void  testException(){

        Assertions.assertThrows(IllegalArgumentException.class, ()-> Triangle.calcSquare(-5,6,8),"Exception has not been thrown." );

//        try {
//            Triangle.calcSquare(-2,3,4);
//            Assertions.fail("Exception has not been thrown.");
//        }
//        catch (IllegalArgumentException e){
//        }
    }

    @ParameterizedTest
    @CsvSource({"3,4,5,6", "4,5,6,9.9215"})
    public void testCalc( int a, int b, int c, double s){
        double actualResult =  Triangle.calcSquare(a, b, c);
        Assert.assertEquals(s,actualResult,0.0001);
    }

}
