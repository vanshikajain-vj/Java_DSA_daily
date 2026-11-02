package Day6.Implementation;

public class Main {

    public static void main(String[] args) {

        Result<String> result1 = Result.success("User created");
        Result<String> result2 = Result.failure("User not found");

        if (result1.isSuccess()) {
            System.out.println(result1.getValue());
        }

        if (!result2.isSuccess()) {
            System.out.println(result2.getError());
        }
    }
}
