public class Exercise4 {
	public static void main(String[] args) {
		double r = Input.askDouble ("What is the circle radius?");
		
		Circle circle1 = new Circle(r);
		
		if (circle1.calculateArea() >= 10) {
		    System.out.println("This circle is big.");
		  }
		  else {
		    System.out.println("This circle is small.");  
		  }
	}
}
