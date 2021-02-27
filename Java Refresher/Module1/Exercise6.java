public class Exercise6 {
    public static void main(String[] args) {
        String u = Input.askString ("username:");
        String p = Input.askString ("password:");

        if (u.equals("joe") && p.equals("guess")) {
            System.out.println("Welcome, joe!");
        }
        else {
            System.out.println("Incorrect username or password.");
        }
    }
}
