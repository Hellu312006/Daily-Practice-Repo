package Day_19;

// Q4: NumberFormatException handle karna
public class practical_194 {

    static void convertToNumber(String input) {
        int number = Integer.parseInt(input);
        System.out.println("Converted Number: " + number);
    }

    public static void main(String[] args) {
        String input = "Java123";

        try {
            convertToNumber(input);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format! String number me convert nahi ho sakti.");
        }

        System.out.println("Program successfully continue hua.");
    }
}
