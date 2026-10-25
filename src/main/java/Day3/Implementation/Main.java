package Day3.Implementation;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        UUID id = UUID.randomUUID();
        Date date = new Date();

        List<String> roles = new ArrayList<>();
        roles.add("USER");

        UserAccount account = new UserAccount(id, date, roles);

        date.setTime(0);
        roles.add("ADMIN");

        System.out.println(account.getCreatedAt());
        System.out.println(account.getRoles()); // [USER]

        account.getRoles().add("MANAGER");
        System.out.println(account.getRoles());

        // Compare accounts using UUID
        UserAccount another = new UserAccount(
                id, new Date(), List.of("ADMIN")
        );

        System.out.println(account.equals(another));
        System.out.println(account.hashCode() == another.hashCode());
    }
}