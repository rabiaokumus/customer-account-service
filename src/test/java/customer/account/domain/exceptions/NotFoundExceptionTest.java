package customer.account.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotFoundExceptionTest {
    @Test
    void testExceptionMessage() {
        String expectedMessage = "Resource not found";
        NotFoundException exception = new NotFoundException(expectedMessage);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testExceptionIsRuntimeException() {
        String expectedMessage = "Another not found error";
        NotFoundException exception = new NotFoundException(expectedMessage);
        assertTrue(exception instanceof RuntimeException);
    }
}
