//Chelsea Florquin 28/04/2025
package tpEnumeration;

public class Exercice3 {
	enum Operation {
		ADD {
			public double appliquer(double a, double b) {
			return a + b;
			}
		},
		
		SUBTRACT {
			public double appliquer(double a, double b) {
				return a - b;
			}
		},
		MULTIPLY {
			public double appliquer(double a, double b) {
				return a * b;
			}
		},
		DIVIDE {
			public double appliquer(double a, double b) {
				return a / b;
			}
		};
		public abstract double appliquer(double a , double b);
	}
}
