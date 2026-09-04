package Day_16;

class Printer {
    // Display integer
    void display(int num) {
        System.out.println("Integer: " + num);
    }

    // Display string
    void display(String text) {
        System.out.println("String: " + text);
    }

    // Display string and integer
    void display(String text, int num) {
        System.out.println("String: " + text + ", Integer: " + num);
    }

    // Display double
    void display(double decimal) {
        System.out.println("Double: " + decimal);
    }
}

public class practical_163 {
    public static void main(String[] args) {
        Printer p = new Printer();

        p.display(100);
        p.display("Hello Java");
        p.display("Age", 20);
        p.display(99.5);
    }
}
