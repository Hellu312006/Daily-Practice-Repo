package Day_19;

// Q11: Method mein exception handling
public class practical_201 {

    static void calculatePercentage(int obtainedMarks, int totalMarks) {
        try {
            int percentage = (obtainedMarks * 100) / totalMarks;
            System.out.println("Percentage: " + percentage + "%");
        } catch (ArithmeticException e) {
            System.out.println("Method Error: Total marks 0 nahi ho sakte!");
        }
    }

    static void parseAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            System.out.println("Parsed User Age: " + age);
        } catch (NumberFormatException e) {
            System.out.println("Method Error: Invalid age input '" + ageStr + "'! Only numbers allowed.");
        }
    }

    public static void main(String[] args) {
        calculatePercentage(450, 0);
        parseAge("Twenty");
    }
}
