package Demo;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProfilerTest {

    @Test
    void memoryValuesAreValid() {
        Runtime r = Runtime.getRuntime();

        assertTrue(r.totalMemory() > 0);
        assertTrue(r.freeMemory() >= 0);
        assertTrue(r.maxMemory() > 0);
    }

    @Test
    void objectsAreCreated() {
        List<byte[]> list =
                MemoryLoadSimulator.createObjectsForTest();

        assertEquals(1000, list.size());
        assertEquals(1024, list.get(0).length);
    }

    @Test
    void profilerRejectsNullTask() {
        assertThrows(
                IllegalArgumentException.class,
                () -> MemoryProfiler.measure("Test", null)
        );
    }
}

