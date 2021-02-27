public class Exercise3 {
	public static void main(String[] args) {
		double r = Input.askDouble ("What is the circle radius?");
		
		Circle circle1 = new Circle(r);
		circle1.showArea();
		
	}
}
