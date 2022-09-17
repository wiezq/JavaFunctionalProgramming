package module4.Optionals;
import java.util.*;

class PrintLoginQuiz {

    public static void printLoginIfPro(Set<Userr> userrs, String id) {
        for (Userr userr : userrs) {
            if (userr.getAccount().isPresent()
                && userr.getAccount().get().getId().equals(id)
                && userr.getAccount().get().getType().equals("pro")) {
                System.out.println(userr.getLogin());

            }
        }

    }
}

class Accountt {
    private String id;
    private String type;

    public Accountt(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}

class Userr {
    private String login;
    private Accountt accountt;

    public Userr(String login, Accountt accountt) {
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
