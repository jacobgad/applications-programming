public class Exercise9 {
	public static void main(String[] args) {
		double x1 = Input.askDouble ("Enter x coordinate for point 1:");
		double y1 = Input.askDouble ("Enter y coordinate for point 1:");
		double x2 = Input.askDouble ("Enter x coordinate for point 2:");
		double y2 = Input.askDouble ("Enter y coordinate for point 2:");
		
		double d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
		
		System.out.println("The distance between the two points is "+d);
	}
}
