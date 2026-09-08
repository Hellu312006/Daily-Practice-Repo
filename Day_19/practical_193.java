package Day_19;

// Q3: NullPointerException handle karna
public class practical_193 {

    static void printLength(String str) {
        System.out.println("String length: " + str.length());
    }

    public static void main(String[] args) {
        String name = null;

        try {
            printLength(name);
        } catch (NullPointerException e) {
            System.out.println("Error: Null value par method call nahi kar sakte! (NullPointerException)");
        }

        System.out.println("Program successfully continue hua.");
    }
}
