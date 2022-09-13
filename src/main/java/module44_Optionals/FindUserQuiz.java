package module44_Optionals;

import java.util.*;

class FindUserQuiz {

    public static Optional<User> findUserByAccountId(Set<User> users, String id) {
        Optional<User> ans = Optional.empty();
        for(User u: users)
        {
            Optional<Account> ac = u.getAccount();
            if(ac.isPresent()){
                if(ac.get().getId().equals(id)){
                    ans = Optional.of(u);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

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
    private final Account account;

    public User(String login, Account account) {
        this.login = login;
        this.account = account;
    }

    public String getLogin() {
        return login;
    }

    public Optional<Account> getAccount() {
        return Optional.ofNullable(account);
    }
}
