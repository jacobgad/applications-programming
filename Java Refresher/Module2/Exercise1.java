public class Exercise1 {
    public static void main(String[] args) {
        int i = Input.askInt ("Pick a number (1-13):");
        String s = Input.askString ("Pick a suit:");

        if (i<13) {
            System.out.println("You picked the "+i+" of "+s);
        }
        else {
            System.out.println("The number you picked is too high");
        }

    }
}
