/**

 * @author Mr. Rasmussen

 */

package fracCalc;

import java.util.*;

public class FracCalc {

	public static void main(String[] args) {

		// User Input code

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

	static int wholeResult;

	static String wholeString;

	static String bottomString;

	static String topString;

	static int commonDenominator;

	static int finalNum;

	static int finalDen;

	static String result;

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

		// Parsing user input

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

// ADDITION CALCULATIONS

		if (operator.equals("+")) {

			commonDenominator = denominator1 * denominator2;

			// Checking for different scenarios of denominators and sign values

			if (wholeNumber1 != 0 && wholeNumber2 != 0) {

				int impropNum1 = (Math.abs(wholeNumber1) * denominator1 + numerator1) * denominator2;

				int impropNum2 = (Math.abs(wholeNumber2) * denominator2 + numerator2) * denominator1;

				if (wholeNumber1 < 0 || numerator1 < 0) {

					impropNum1 *= -1;

				}

				if (wholeNumber2 < 0 || numerator2 < 0) {

					impropNum2 *= -1;

				}

				numResult = impropNum1 + impropNum2;

				wholeResult = 0;

			}

			else if (wholeNumber1 == 0 && wholeNumber2 != 0) {

				int impropNum1 = numerator1 * denominator2;

				int impropNum2 = (Math.abs(wholeNumber2) * denominator2 + numerator2) * denominator1;

				if (wholeNumber1 < 0 || numerator1 < 0) {

					impropNum1 *= -1;

				}

				if (wholeNumber2 < 0 || numerator2 < 0) {

					impropNum2 *= -1;

				}

				numResult = impropNum1 + impropNum2;

				wholeResult = 0;

			}

			else if (wholeNumber1 != 0 && wholeNumber2 == 0) {

				int impropNum1 = (Math.abs(wholeNumber1) * denominator1 + numerator1) * denominator2;

				int impropNum2 = (Math.abs(wholeNumber2) * denominator2 + numerator2) * denominator1;

				if (wholeNumber1 < 0 || numerator1 < 0) {

					impropNum1 *= -1;

				}

				if (wholeNumber2 < 0 || numerator2 < 0) {

					impropNum2 *= -1;

				}

				numResult = impropNum1 + impropNum2;

				wholeResult = 0;

			}

			else {

				numResult = (numerator1 * denominator2) + (numerator2 * denominator1);

				commonDenominator = denominator1 * denominator2;

				wholeResult = 0;

			}

		}

// SUBTRACTION CALCULATIONS

		if (operator.equals("-")) {

			commonDenominator = denominator1 * denominator2;

			// Checking for different scenarios of denominators and sign values

			if (wholeNumber1 != 0 && wholeNumber2 != 0) {

				int impropNum1 = (Math.abs(wholeNumber1) * denominator1 + numerator1) * denominator2;

				int impropNum2 = (Math.abs(wholeNumber2) * denominator2 + numerator2) * denominator1;

				if (wholeNumber1 < 0 || numerator1 < 0) {

					impropNum1 *= -1;

				}

				if (wholeNumber2 < 0 || numerator2 < 0) {

					impropNum2 *= -1;

				}

				numResult = impropNum1 - impropNum2;

				wholeResult = 0;

			}

			else if (wholeNumber1 == 0 && wholeNumber2 != 0) {

				int impropNum1 = numerator1 * denominator2;

				int impropNum2 = (Math.abs(wholeNumber2) * denominator2 + numerator2) * denominator1;

				if (wholeNumber1 < 0 || numerator1 < 0) {

					impropNum1 *= -1;

				}

				if (wholeNumber2 < 0 || numerator2 < 0) {

					impropNum2 *= -1;

				}

				numResult = impropNum1 - impropNum2;

				wholeResult = 0;

			}

			else if (wholeNumber1 != 0 && wholeNumber2 == 0) {

				int impropNum1 = (Math.abs(wholeNumber1) * denominator1 + numerator1) * denominator2;

				int impropNum2 = (Math.abs(wholeNumber2) * denominator2 + numerator2) * denominator1;

				if (wholeNumber1 < 0 || numerator1 < 0) {

					impropNum1 *= -1;

				}

				if (wholeNumber2 < 0 || numerator2 < 0) {

					impropNum2 *= -1;

				}

				numResult = impropNum1 - impropNum2;

				wholeResult = 0;

			}

			else {

				if (denominator1 != denominator2) {

					numResult = (numerator1 * denominator2) - (numerator2 * denominator1);

					commonDenominator = denominator1 * denominator2;

					wholeResult = 0;

				} else {

					numResult = numerator1 - numerator2;

					commonDenominator = denominator1;

					wholeResult = 0;

				}

			}

		}

// MULTIPLICATION CALCULATIONS

		if (operator.equals("*")) {

			if (operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-") && wholeNumber1 != 0) {

				numResult = ((wholeNumber1 * denominator1) - numerator1) * ((wholeNumber2 * denominator2) + numerator2);

				commonDenominator = denominator1 * denominator2;

			}

			else if (!operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-")

					&& wholeNumber1 != 0) {

				numResult = ((wholeNumber1 * denominator1) + numerator1) * ((wholeNumber2 * denominator2) - numerator2);

				commonDenominator = denominator1 * denominator2;

			}

			else if (operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-")

					&& wholeNumber1 != 0) {

				numResult = ((wholeNumber1 * denominator1) - numerator1) * ((wholeNumber2 * denominator2) - numerator2);

				commonDenominator = denominator1 * denominator2;

			}

			else if (!operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-")

					&& wholeNumber1 != 0) {

				numResult = ((wholeNumber1 * denominator1) + numerator1) * ((wholeNumber2 * denominator2) + numerator2);

				commonDenominator = denominator1 * denominator2;

			}

			else {

				numResult = numerator1 * numerator2;

				commonDenominator = denominator1 * denominator2;

			}

			wholeResult = 0;

		}

// DIVISION CALCULATIONS

		if (operator.equals("/")) {

			// Changes all to improper fractions

			if (numerator1 != 0 && numerator2 != 0) {

				if (operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-")

						&& wholeNumber1 != 0) {

					numResult = (wholeNumber1 * denominator1 - numerator1) * denominator2;

					commonDenominator = denominator1 * (wholeNumber2 * denominator2 + numerator2);

				}

				else if (!operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-")

						&& wholeNumber1 != 0) {

					numResult = (wholeNumber1 * denominator1 + numerator1) * denominator2;

					commonDenominator = denominator1 * (wholeNumber2 * denominator2 - numerator2);

				}

				else if (operand1.substring(0, 1).equals("-") && operand2.substring(0, 1).equals("-")

						&& wholeNumber1 != 0) {

					numResult = (wholeNumber1 * denominator1 - numerator1) * denominator2;

					commonDenominator = denominator1 * (wholeNumber2 * denominator2 - numerator2);

				}

				else if (!operand1.substring(0, 1).equals("-") && !operand2.substring(0, 1).equals("-")

						&& wholeNumber1 != 0) {

					numResult = (wholeNumber1 * denominator1 + numerator1) * denominator2;

					commonDenominator = denominator1 * (wholeNumber2 * denominator2 + numerator2);

				}

				else {

					numResult = numerator1 * denominator2;

					commonDenominator = denominator1 * numerator2;

				}

				wholeResult = 0;

			}

			else if (numerator1 == 0 && numerator2 == 0) {

				if (wholeNumber1 < 0 && wholeNumber2 < 0) {

					numResult = Math.abs(wholeNumber1);

					commonDenominator = Math.abs(wholeNumber2);

					wholeResult = 0;

				}

				else {

					numResult = wholeNumber1;

					commonDenominator = wholeNumber2;

					wholeResult = 0;

				}

			}

			else if (numerator2 == 0) {

				numResult = wholeNumber1 * denominator1 + numerator1;

				commonDenominator = denominator1 * wholeNumber2;

				wholeResult = 0;

			}

		}

		if (operator.equals("*") || operator.equals("/")) {

			if (operand1.equals("0") || operand2.equals("0") || operand1.equals("-0") || operand2.equals("-0")) {

				return Integer.toString(0);

			}

		}

		String finalResult = reduceAnswer(operator, wholeResult, numResult, commonDenominator);

		return finalResult;

	}

	// Method for reducing fractions

	public static String reduceAnswer(String operator, int wholeResult, int numResult, int commonDenominator) {

		System.out.println(wholeResult + " " + numResult + " " + commonDenominator);

		// Reduce improper fractions

		if (Math.abs(numResult) >= Math.abs(commonDenominator) && commonDenominator != 0) {

			int extra = Math.abs(numResult) / Math.abs(commonDenominator);

			if (wholeResult == 0 && numResult < 0 && commonDenominator < 0) {

				wholeResult = Math.abs(wholeResult) + extra;

			}

			else if (wholeResult == 0 && numResult < 0 || commonDenominator < 0) {

				wholeResult = -1 * (Math.abs(wholeResult) + extra);

			}

			else if (wholeResult < 0 && numResult > 0) {

				wholeResult = -1 * (Math.abs(wholeResult) + extra);

			}

			else if (wholeResult > 0 && numResult < 0) {

				wholeResult = -1 * (Math.abs(wholeResult) + extra);

			}

			else {

				wholeResult = wholeResult + extra;

			}

			numResult = Math.abs(numResult % commonDenominator);

		}

		int tempNum = Math.abs(numResult);

		int tempDen = Math.abs(commonDenominator);

		int oldNum = numResult;

		int oldDen = commonDenominator;

		numResult = Math.abs(numResult);

		commonDenominator = Math.abs(commonDenominator);

		System.out.println(wholeResult + " " + tempNum + " " + tempDen);

		// Look for common factor

		while (numResult != commonDenominator && numResult != 0) {

			if (numResult > commonDenominator) {

				numResult = numResult - commonDenominator;

			}

			else {

				commonDenominator = commonDenominator - numResult;

			}

		}

		// Divide by the common factor which is "numResult"

		if (numResult != 0) {

			finalNum = tempNum / numResult;

			finalDen = tempDen / numResult;

		}

		if (oldNum > 0 && oldDen < 0 && wholeResult == 0) {

			finalNum *= -1;

		}

		else if (oldNum < 0 && oldDen > 0 && wholeResult == 0) {

			finalNum *= -1;

		}

		System.out.println(wholeResult + " " + finalNum + " " + finalDen);

		// Convert back into String

		wholeString = Integer.toString(wholeResult);

		topString = Integer.toString(finalNum);

		bottomString = Integer.toString(finalDen);

		// Choosing which output

		if (wholeResult != 0 && numResult != 0) {

			result = wholeString + "_" + topString + "/" + bottomString;

		}

		else if (wholeResult == 0 && numResult != 0) {

			result = topString + "/" + bottomString;

		}

		else if (wholeResult != 0 && numResult == 0) {

			result = wholeString;

		}

		else {

			result = "0";

		}

		return result;
	}
}