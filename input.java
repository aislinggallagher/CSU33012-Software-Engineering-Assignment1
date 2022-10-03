import java.util.Scanner;

public class input {

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter the numeric expression you would like to evaluate: ");
            Scanner input = new Scanner(System.in);
            String expression = input.next();
            if (isValid(expression))
                System.out.println("Success");
            else {
                System.out.println("Invalid expression to evaluate");
                System.out.println("Type 'exit' if you would like to leave the calculator, if not press enter: ");
                String s = input.next();
                if (s.equalsIgnoreCase("exit")) {
                    exit = true;
                }
            }
        }

    }

    public static boolean isValid(String exp) {
        char lastChar = '1';
        int n = exp.length() - 1;
        if (exp.charAt(0) == '+' | exp.charAt(0) == '-' | exp.charAt(0) == '*')
            return false;
        for (char c : exp.toCharArray()) {
            if (c >= '0' && c <= '9') {
                lastChar = c;
            } else if (c == '+' | c == '-' | c == '*') {
                if (lastChar == '+' | lastChar == '-' | lastChar == '*')
                    return false;
                else
                    lastChar = c;
            } else
                return false;
        }
        if (exp.charAt(n) == '+' | exp.charAt(n) == '-' | exp.charAt(n) == '*')
            return false;
        return true;
    }
}