import java.util.Random;

public class Exercise5 {
    public static void main(String[] args) {
        Random random = new Random(7777);
        int next = random.nextInt(100);
        System.out.println("Here is a random number: " + next); 
    }
}
