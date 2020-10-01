package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import be.pxl.ja.streamingservice.exception.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SetDateOfBirthTest {

    private  Profile testProfile = new Profile("test");
    private static final LocalDate DATE_IN_THE_FUTURE = LocalDate.now().plusDays(1);
    private static final LocalDate VALID_DATE = LocalDate.of(1999,1,11);


    @Test
    public void validDateOfBirth(){
        testProfile.setDateOfBirth(VALID_DATE);

        assertEquals(VALID_DATE, testProfile.getDateOfBirth());
    }

    @Test
    public void throwsInvalidDateExceptionWhenDateOfBirthIsFarInTheFuture(){

        assertThrows(InvalidDateException.class, () -> {
            testProfile.setDateOfBirth(DATE_IN_THE_FUTURE);
        });
    }
}
