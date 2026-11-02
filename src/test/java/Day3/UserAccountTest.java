package Day3;
import Day3.Implementation.UserAccount;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

    @Test
    void testHashMapBucketDistribution() {
        Map<UserAccount, String> map = new HashMap<>();

        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        UserAccount u1 = new UserAccount(id1, new Date(), List.of("USER"));
        UserAccount u2 = new UserAccount(id2, new Date(), List.of("ADMIN"));

        map.put(u1, "Vijju");
        map.put(u2, "Alex");

        assertEquals(2, map.size());
        assertEquals("Vijju", map.get(u1));
        assertEquals("Alex", map.get(u2));
    }
}
