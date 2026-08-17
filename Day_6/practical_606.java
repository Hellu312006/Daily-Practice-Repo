package Day_6;

public class practical_606 {
    public static void main(String[] args) {
        
        System.out.println("--- Method Demonstration ---");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("After append: " + sb);
        sb.insert(5, ",");
        System.out.println("After insert: " + sb);
        sb.replace(6, 12, "Java");
        System.out.println("After replace: " + sb);
        sb.delete(5, 6);
        System.out.println("After delete: " + sb);

    
        System.out.println("\n--- Performance Comparison (10 million appends) ---");
        
        long startTime = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 10000000; i++) {
            sBuffer.append("a");
        }
        long durationBuffer = System.currentTimeMillis() - startTime;
        System.out.println("StringBuffer time: " + durationBuffer + " ms");

        startTime = System.currentTimeMillis();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            sBuilder.append("a");
        }
        long durationBuilder = System.currentTimeMillis() - startTime;
        System.out.println("StringBuilder time: " + durationBuilder + " ms");
    }
}
