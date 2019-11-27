/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {
		Scanner ui = new Scanner(System.in);

		System.out.println("What would you like to calculate? (Type \"quit\" to exit calculator)");

		String input = ui.nextLine();

		System.out.println(produceAnswer(input));

		while (!input.equals("quit")) {

			System.out.println("What would you like to calculate? (Type \"quit\" to exit calculator)");
			input = ui.nextLine();
			System.out.println(produceAnswer(input));

		}
	}

	static int wholeNumber1;
	static int numerator1;
	static int denominator1;
	static int wholeNumber2;
	static int numerator2;
	static int denominator2;
	static int numResult;
	static int commonDenominator;
	static int wholeResult;
	static String wholeString;
	static String bottomString;
	static String topString;
	static String result;
	static int impropNum;
	static int impropDen;
	static String impropNumString;
	static String impropDenString;

	public static String produceAnswer(String input) {

		int space1 = input.indexOf(" ");
		int length = input.length();
		String operand1 = input.substring(0, space1);
		int lengthOperand1 = operand1.length();
		String operator = input.substring(space1 + 1, space1 + 2);
		String operand2 = input.substring(space1 + 3, length);
		int lengthOperand2 = operand2.length();
		int indexUnderscore1 = operand1.indexOf("_");
		int indexSlash1 = operand1.indexOf("/");

		if (indexUnderscore1 > 0 && indexSlash1 > 0) {

			wholeNumber1 = Integer.parseInt(operand1.substring(0, indexUnderscore1));
			numerator1 = Integer.parseInt(operand1.substring(indexUnderscore1 + 1, indexSlash1));
			denominator1 = Integer.parseInt(operand1.substring(indexSlash1 + 1, lengthOperand1));

		}

		else if (indexUnderscore1 == -1 && indexSlash1 > 0) {

			wholeNumber1 = 0;
			numerator1 = Integer.parseInt(operand1.substring(0, indexSlash1));
			denominator1 = Integer.parseInt(operand1.substring(indexSlash1 + 1));

		}

		else {

			wholeNumber1 = Integer.parseInt(operand1);
			numerator1 = 0;
			denominator1 = 1;

		}

		int indexUnderscore2 = operand2.indexOf("_");
		int indexSlash2 = operand2.indexOf("/");

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

		if (operator.equals("+")) {
			
			if (numerator1 == 0 && numerator2 == 0 && denominator1 == 1 && denominator2 == 1) {
				
				int wholeResult = wholeNumber1 + wholeNumber2;
				
				result = Integer.toString(wholeResult);
			}

			else if (denominator1 == denominator2) {

				if (operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-")) {

					numResult = numerator1 - numerator2;
				} else {

					numResult = numerator1 + numerator2;

				}
				commonDenominator = denominator1;
				wholeResult = wholeNumber1 + wholeNumber2;
				wholeString = Integer.toString(wholeResult);
				topString = Integer.toString(numResult);
				bottomString = Integer.toString(commonDenominator);

				if (wholeResult != 0 && numResult > 0) {

					result = wholeString + "_" + topString + "/" + bottomString;
				}

				else if (wholeResult == 0 && numResult > 0) {

					result = topString + "/" + bottomString;
				}
			}

			else {

				commonDenominator = denominator1 * denominator2;
				numResult = (numerator1 * denominator2) + (numerator2 * denominator1);
				wholeResult = wholeNumber1 + wholeNumber2;
				wholeString = Integer.toString(wholeResult);
				topString = Integer.toString(numResult);
				bottomString = Integer.toString(commonDenominator);

				if (wholeResult != 0 && numResult > 0) {

					result = wholeString + "_" + topString + "/" + bottomString;
				}

				else if (wholeResult == 0 && numResult > 0) {

					result = topString + "/" + bottomString;
				}
			}
		}

		if (operator.equals("-")) {

			if (denominator1 == denominator2) {

				numResult = numerator1 - numerator2;
				commonDenominator = denominator1;
				wholeResult = wholeNumber1 - wholeNumber2;
				wholeString = Integer.toString(wholeResult);
				topString = Integer.toString(numResult);
				bottomString = Integer.toString(commonDenominator);

				if (wholeResult != 0 && numResult > 0) {

					result = wholeString + "_" + topString + "/" + bottomString;
				}

				else if (wholeResult == 0 && numResult > 0) {

					result = topString + "/" + bottomString;
				}
				
				else if (wholeResult == 0 && numResult == 0) {
					
					result = Integer.toString(0);
				}
			}

			else {

				commonDenominator = denominator1 * denominator2;
				numResult = (numerator1 * denominator2) - (numerator2 * denominator1);
				wholeResult = wholeNumber1 - wholeNumber2;

				if (numResult < 0 && wholeResult < 0) {

					numResult *= -1;
					wholeResult -= 1;
				}

				else if (numResult < 0 && wholeResult > 0) {

					numResult *= -1;
				}

				wholeString = Integer.toString(wholeResult);
				topString = Integer.toString(numResult);
				bottomString = Integer.toString(commonDenominator);

				if (wholeResult != 0 && numResult != 0) {

					result = wholeString + "_" + topString + "/" + bottomString;
				}

				else if (wholeResult == 0 && numResult != 0) {

					result = topString + "/" + bottomString;
				}
			}
		}

		if (operator.equals("*")) {

			if (operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-") && wholeNumber1 != 0) {

				impropNum = ((wholeNumber1 * denominator1) - numerator1) * ((wholeNumber2 * denominator2) + numerator2);
				impropDen = denominator1 * denominator2;
			}

			else if (!operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-")
					&& wholeNumber1 != 0) {

				impropNum = ((wholeNumber1 * denominator1) + numerator1) * ((wholeNumber2 * denominator2) - numerator2);
				impropDen = denominator1 * denominator2;
			}

			else if (operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-")
					&& wholeNumber1 != 0) {

				impropNum = ((wholeNumber1 * denominator1) - numerator1) * ((wholeNumber2 * denominator2) - numerator2);
				impropDen = denominator1 * denominator2;
			}

			else if (!operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-")
					&& wholeNumber1 != 0) {

				impropNum = ((wholeNumber1 * denominator1) + numerator1) * ((wholeNumber2 * denominator2) + numerator2);
				impropDen = denominator1 * denominator2;
			}

			else {

				impropNum = numerator1 * numerator2;
				impropDen = denominator1 * denominator2;
			}

			topString = Integer.toString(impropNum);
			bottomString = Integer.toString(impropDen);

			if (impropDen == 1) {

				result = topString;
			}

			else {

				result = topString + "/" + bottomString;

			}
		}

		if (operator.equals("/")) {

			if (operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-") && wholeNumber1 != 0) {

				impropNum = (wholeNumber1 * denominator1 - numerator1) * denominator2;
				impropDen = denominator1 * (wholeNumber2 * denominator2 + numerator2);
			}

			else if (!operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-") && wholeNumber1 != 0) {
				
				impropNum = (wholeNumber1 * denominator1 + numerator1) * denominator2;
				impropDen = denominator1 * (wholeNumber2 * denominator2 - numerator2);
			}

			else if (operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-") && wholeNumber1 != 0) {
				
				impropNum = (wholeNumber1 * denominator1 - numerator1) * denominator2;
				impropDen = denominator1 * (wholeNumber2 * denominator2 - numerator2);
			}

			else if (!operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-") && wholeNumber1 != 0) {
				
				impropNum = (wholeNumber1 * denominator1 + numerator1) * denominator2;
				impropDen = denominator1 * (wholeNumber2 * denominator2 + numerator2);
			}

			else {
				
				impropNum = numerator1 * denominator2;
				impropDen = denominator1 * numerator2;
			}

			topString = Integer.toString(impropNum);
			bottomString = Integer.toString(impropDen);

			if (impropDen == 1) {

				result = topString;
			}

			else {

				result = topString + "/" + bottomString;

			}
		}

		String answer = result;
		String an = Integer.toString(wholeResult);
		return answer;
	}
}
