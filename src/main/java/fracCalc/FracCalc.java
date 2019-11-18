/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);

		System.out.println("What would you like to calculate?");

		String input = ui.nextLine();
		
		System.out.println(produceAnswer(input));
		
		while (input != "quit") {
			
			
			System.out.println("What would you like to calculate?");
			input = ui.nextLine();	
			System.out.println(produceAnswer(input));
			
		}
		

	}

	static int space1;

	static int length;

	static String operand1;
	
	static int lengthOperand1;

	static String operator;

	static String operand2;
	
	static int lengthOperand2; 

	static int indexUnderscore1;

	static int indexSlash1;

	static int wholeNumber1;

	static int numerator1;

	static int denominator1;
	
	static int indexUnderscore2;

	static int indexSlash2;

	static int wholeNumber2;

	static int numerator2;

	static int denominator2;	

	public static String produceAnswer(String input) {

		space1 = input.indexOf(" ");

		length = input.length();

		operand1 = input.substring(0, space1);
		
		lengthOperand1 = operand1.length();

		operator = input.substring(space1 + 1, space1 + 2);

		operand2 = input.substring(space1 + 3, length);
		
		lengthOperand2 = operand2.length();

		indexUnderscore1 = operand1.indexOf("_");
		
		indexSlash1 = operand1.indexOf("/");

		if (indexUnderscore1 > 0 && indexSlash1 > 0) {

			wholeNumber1 = Integer.parseInt(operand1.substring(0, indexUnderscore1));
			
			numerator1 = Integer.parseInt(operand1.substring(indexUnderscore1 + 1, indexSlash1));
			
			denominator1 = Integer.parseInt(operand1.substring(indexSlash1 + 1, lengthOperand1));

		}

		else if (indexUnderscore1 == -1 && indexSlash1 > 0) {

			wholeNumber1 = 0;
			
			numerator1 = Integer.parseInt(operand1.substring(0, indexSlash1));
			
			denominator1 = Integer.parseInt(operand1.substring(indexSlash1 + 1, lengthOperand1));

		}

		else {

			wholeNumber1 = Integer.parseInt(operand1);
			
			numerator1 = 0; 
			
			denominator1 = 1; 

		}
		
		lengthOperand2 = operand2.length();
		
		indexUnderscore2 = operand2.indexOf("_"); 
		
		indexSlash2 = operand2.indexOf("/");
		
		if (indexUnderscore2 > 0 && indexSlash2 > 0) {
			
			wholeNumber2 = Integer.parseInt(operand2.substring(0, indexUnderscore2));
			
			numerator2 = Integer.parseInt(operand2.substring(indexUnderscore2 + 1, indexSlash2));
			
			denominator2 = Integer.parseInt(operand2.substring(indexSlash2 + 1, lengthOperand2)); 

		}

		else if (indexUnderscore2 == -1 && indexSlash2 > 0) {

			wholeNumber2 = 0;
			
			numerator2 = Integer.parseInt(operand2.substring(0, indexSlash2));
			
			denominator2 = Integer.parseInt(operand2.substring(indexSlash2 + 1, lengthOperand2));
			
		}

		else {

			wholeNumber2 = Integer.parseInt(operand2);
			
			numerator2 = 0; 
			
			denominator2 = 1; 

		}
		
		String result = "whole:" + wholeNumber2 + " numerator:" + numerator2 + " denominator:" + denominator2;
				
		return result;
	}

}
