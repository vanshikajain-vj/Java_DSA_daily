package Day6;

import Day6.Implementation.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void testResultPipeline() {
        Result<String> success = Result.success("Amit");
        assertTrue(success.isSuccess());
        assertEquals("Amit", success.getValue());

        Result<String> failure = Result.failure("User not found");
        assertFalse(failure.isSuccess());
        assertEquals("User not found", failure.getError());

    }
}
