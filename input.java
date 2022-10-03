import java.util.Scanner;


public class input {

	public static void main(String[] args) {
		System.out.print("Enter the numeric expression you would like to evaluate:");
		Scanner input = new Scanner( System.in );
        String value = input.next();
        boolean check = isNumeric(value);
		input.close();
		
		System.out.println(check);
		

    } 
    
    public static boolean isNumeric(String string) {
        try {
            Double.parseDouble(string);
            return true;
        }   catch(NumberFormatException e){
            return false;
        }    
    }
}