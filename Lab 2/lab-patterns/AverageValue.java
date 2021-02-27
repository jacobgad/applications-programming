public class AverageValue {
    public static void main(String[] args) {
        int sum = 0;
        System.out.print ("Value: ");
        int i = In.nextInt();
        int count = 1;
        while (i != -1) {
            sum += i;
            System.out.print ("Value: ");
            i = In.nextInt();
            if (i > -1) {
                count ++;   
            }
        }

        double average = (double)sum / (double)count;
        if (count > 1) {
            System.out.println("Average = " + average);
        }
    }
}
