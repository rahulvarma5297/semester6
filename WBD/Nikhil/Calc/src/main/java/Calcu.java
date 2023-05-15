
public class Calcu {
	public double Calc(char operator,double number1,double number2) {
		double result=0;
		switch (operator) {
	      case '+':
	        result = number1 + number2;
	        break;
	      case '-':
	        result = number1 - number2;
	        break;
	      case '*':
	        result = number1 * number2;
	        break;
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
