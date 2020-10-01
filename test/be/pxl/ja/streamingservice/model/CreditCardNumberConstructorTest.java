package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreditCardNumberConstructorTest {

    @Test
    public void throwsIllegalArgumentExceptionWhenCvcNAN(){

        assertThrows(IllegalArgumentException.class, () ->{
            new CreditCardNumber("53218 76532 1476 54", "1 2 a");
        });
    }

    @Test
    public void throwsIllegalArgumentExceptionWhenCvcLongerThanCVC_LENGTH(){

        assertThrows(IllegalArgumentException.class, () -> {
            new CreditCardNumber("53218 76532 1476 54", "1 2 34");
        });
    }

    @Test
    public void throwsInvalidArgumentExceptionWhenCvcShorterThanCVC_LENGTH(){

        assertThrows(IllegalArgumentException.class, () ->{
            new CreditCardNumber("53218 76532 1476 54", "1 2 ");
        });
    }
}
