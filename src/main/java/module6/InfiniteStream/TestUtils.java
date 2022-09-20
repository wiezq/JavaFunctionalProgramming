package module6.InfiniteStream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TestUtils {
    @Test
    void testGenerateUsers()
    {
        List<User> userStream = Utils.generateUsers(10).toList();
        System.out.println(userStream);

    }
}
