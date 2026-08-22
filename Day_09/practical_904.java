package Day_09;

public class practical_904 {
    public static void main(String[] args) {

        String str = "hello world";
        char search = 'l';

        int count = 0;

        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == search) {
                count++;
            }
        }

        System.out.println("Count = " + count);
    }
}

