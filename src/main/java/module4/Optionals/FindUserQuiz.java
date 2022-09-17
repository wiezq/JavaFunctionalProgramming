package module4.Optionals;

import java.util.*;

class FindUserQuiz {

    public static Optional<Userr> findUserByAccountId(Set<Userr> userrs, String id) {
        Optional<Userr> ans = Optional.empty();
        for(Userr u: userrs)
        {
            Optional<Accountt> ac = u.getAccount();
            if(ac.isPresent()){
                if(ac.get().getId().equals(id)){
                    ans = Optional.of(u);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hi!");

        optional.ifPresent(System.out::println);
        optional.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));

        System.out.println(optional.or(() -> Optional.of("empty")).orElse("empty"));
        System.out.println(optional.filter(str -> str.length() > 5).orElse("empty"));
    }
}

class Account {
    private final String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class User {
    private final String login;
    private final Accountt accountt;

    public User(String login, Accountt accountt) {
        this.login = login;
        this.accountt = accountt;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Accountt> getAccount() {
        return Optional.ofNullable(accountt);
    }
}
