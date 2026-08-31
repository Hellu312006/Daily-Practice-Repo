package Day_12;

public class practical_121 {
    public static void main(String[] args) {
        String role = "admin";

        switch (role) {
            case "admin":
                System.out.println("Welcome Admin");
                break;

            case "student":
                System.out.println("Welcome Student");
                break;

            case "teacher":
                System.out.println("Welcome Teacher");
                break;

            default:
                System.out.println("Unknown User");
        }
    }
}
