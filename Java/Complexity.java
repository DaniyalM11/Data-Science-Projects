// Daniyal Mufti Howmework Assignment 2

public class Complexity {
	
	public static void Method0(int n) {
		int counter = 0;
		for (int i=0; i<n; i++) {
			System.out.println("Operation "+ counter);
			counter++;
		}
	}	
	
	public static void Method1(int n) {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Operation "+ counter);
				counter++;
			}
		}
	}
	
	public static void Method2(int n) {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					System.out.println("Operation "+ counter);
					counter++;
				}
			}
		}	
	}
	
	public static void Method3(int n) {
		int counter = 0;
		for (int i = 1; i < n; i*= 2) {
			System.out.println("Operation "+ counter);
			counter++;
		}
	}
	
	public static void Method4(int n) {
		int counter = 0;
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < n; j*= 2) {
				System.out.println("Operation "+ counter);
				counter++;
			}
		}
		
	}
	
	public static void Method5(int n) {
		int counter = 0;
		for(int i = 1; i < (Math.log(n)/Math.log(2)); i*= 2) {
			System.out.println("Operation "+ counter);
			counter++;
			
		}
	}
	
	public static void Method6(int n) {
		int counter = 0;
		for(int i = 1; i < Math.pow(2, n); i*= 2^i) {
			System.out.println("Operation "+ counter);
			counter++;
		}
	}

//Method6 does not work	
	
// Main for testing purposes	
	public static void main(String[] args) {
//		Complexity.Method0(5);
//		Complexity.Method1(5);
//		Complexity.Method2(5);
//		Complexity.Method3(8);
//		Complexity.Method4(8);
//		Complexity.Method5(65536);
//		Complexity.Method6(3);
		
	}
}


