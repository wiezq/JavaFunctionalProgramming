package module6.InfiniteStream;

import java.util.stream.Stream;

final class Utils {

    private Utils() { }

    public static Stream<User> generateUsers(int numberOfUsers) {
        return Stream.iterate(1, id -> id + 1)
                .limit(numberOfUsers)
                .map(id -> new User(id, String.format("user%d@gmail.com", id)));
    }
}

class User {
    private final long id;
    private final String email;

    User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}