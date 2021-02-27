public class Exercise4 {
    public static void main(String[] args) {
        int i = Input.askInt ("How old are you?");
        if (i>16) {
            System.out.println("You are old enough to drive.");
        }
        else {
            System.out.println("You are not old enough to drive."); 
        }
    }
}
