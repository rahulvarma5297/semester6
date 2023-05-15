
public class Calcul {
	public double calc(char operator,double number1,double number2) {
		double result=0;
		switch (operator) {

	      // performs addition between numbers
	      case '+':
	        result = number1 + number2;
	        break;

	      // performs subtraction between numbers
	      case '-':
	        result = number1 - number2;
	        break;

	      // performs multiplication between numbers
	      case '*':
	        result = number1 * number2;
	        break;

	      // performs division between numbers
	      case '/':
	        result = number1 / number2;
	        break;

	      case '%':
		        result = number1 % number2;
		        break;
		        
	      default:
	        System.out.println("Invalid operator!");
	        break;
	    }
		
		return result;
	}
}
