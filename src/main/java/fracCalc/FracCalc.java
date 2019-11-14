/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;

public class FracCalc {

    public static void main(String[] args)
    {
        Scanner ui = new Scanner(System.in);
   
        System.out.println("What would you like to calculate?"); 
        
        String input = ui.nextLine();
        
        System.out.println(produceAnswer(input));      
        
    }

   
    
    public static String produceAnswer(String input) {
    	
    	int space1 = input.indexOf(" ");
    	
    	int length = input.length();
    	
    	String operand1 = input.substring(space1 - 1);
    	
    	String operator = input.substring(space1 + 1); 
    	
    	String operand2 = input.substring(length - (space1));
    	
        return operand2;
    }


}
