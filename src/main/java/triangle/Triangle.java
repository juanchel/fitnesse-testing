package triangle;

import java.util.Arrays;

public class Triangle {
	int a, b, c;
	
	String type;
	
	public void classify() {
		if (a < 1 || b < 1 || c < 1) {
			type = null;
		}
		
		int maxSide = Math.max(a, Math.max(c, b));
		int otherSides = a + b + c - maxSide;
		if (maxSide >= otherSides) {
			type = null;
		}
		
		if (a == b && b == c) {
			type = "EQUILATERAL";
		} else if (a == b || b == c || a == c) {
			type = "ISOSCELES";
		} else {
			type = "SCALENE";
		}
	}
	
	public boolean isRightAngled() {
		classify();
		if (type == null)
			return false;
		
		int[] sides = new int[3];
		sides[0] = a;
		sides[1] = b;
		sides[2] = c;
		Arrays.sort(sides);
		if (a*a + b*b == c*c) {
			return true;
		}
		return false;
	}
}
