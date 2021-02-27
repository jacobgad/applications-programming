public class MiddleAverage {
    public static void main(String[] args) {
        int sum = 0;
        int min = 1000000;
        int max = 0;
        
        System.out.print ("Value: ");
        int i = In.nextInt();
        int count = 1;

        if (i != -1){
            if (i < min){
                min = i;
            }
        }

        while (i != -1) {
            sum += i;
            System.out.print("Value: ");
            i = In.nextInt();

            if (i > -1) {
                count++;   
            }

            if (i > max) {
                max = i;   
            }

            if (i != -1) {
                if (i < min) {
                    min = i;   
                }
            }

        }

        if (count > 2) {
            double average = ((((double)sum-min-max)/(count-2)));
            System.out.println("Middle average = " + average);
        }
    }
}
