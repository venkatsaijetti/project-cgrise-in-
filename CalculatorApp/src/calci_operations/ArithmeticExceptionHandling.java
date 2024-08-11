package calci_operations;

import java.util.Scanner;

public class ArithmeticExceptionHandling {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter First Number: ");
		int firstNumber = scanner.nextInt();

		System.out.println("Enter Second Number: ");
		int secondNumber = scanner.nextInt();
		
		System.out.println("Choose your operator (+,-,*,/): to perform the operation ");
		char operator = scanner.next().charAt(0);
		
		while(true) {
			try {
				int output;
				switch(operator) {
				case '+':
					output = firstNumber+secondNumber;
					System.out.println("Addition of "+firstNumber+" and "+secondNumber+" is "+output);
					break;
				case '-':
					output = firstNumber-secondNumber;
					System.out.println("Subtraction of "+firstNumber+" and "+secondNumber+" is "+output);
					break;
				case '*':
					output = firstNumber*secondNumber;
					System.out.println("Multiplication of "+firstNumber+" and "+secondNumber+" is "+output);
					break;
				case '/':
					if(secondNumber == 0) {
						throw new ArithmeticException("Division by zero id not possible");
					}
					output = firstNumber/secondNumber;
					System.out.println("Division of "+firstNumber+" and "+secondNumber+" is "+output);
					break;
				default:
					System.out.println("You have entered an Invalid Operator. Please Choose the correct operator.");
					break;
				}
				break;
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Re-enter the Second Number: ");
				secondNumber = scanner.nextInt();
			}
		}
		scanner.close();
	}

}
