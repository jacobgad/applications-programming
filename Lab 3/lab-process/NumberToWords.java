public class NumberToWords {
    public static void main(String[] args) {
        String [] ones ={"zero","one","two","three","four","five","six","seven","eight","nine"};
        String [] teens ={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};      
        String [] tens ={"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

        System.out.print("Number: ");
        int i = In.nextInt();
        while (i != -1){
            if (i<10){
                System.out.println(ones[i]);
            }
            else if (i<20 & i>9) {
                System.out.println(teens[i%10]);
            }
            else if(i>99){
                if (i%100 == 0){
                    System.out.println(ones[i/100] + " hundred"); 
                }
                else {
                    System.out.print(ones[i/100] + " hundred and ");
                    
                    if (i%10 == 0){
                        System.out.println(tens[i/10 % 10]);
                    }
                    else if(i%100 >9 & i%100 <20){
                        System.out.println(teens[i%10]);
                    }
                    else{
                        System.out.println(tens[i/10 % 10] + " " + ones[i%10]);
                    }
                }
            }
            else {
                if(i%10 == 0){
                    System.out.println(tens[i/10 % 10]);
                }
                else{
                    System.out.println(tens[i/10] + " " + ones[i%10]);
                }
            }
            System.out.print("Number: ");
            i = In.nextInt(); 
        }
    }
}