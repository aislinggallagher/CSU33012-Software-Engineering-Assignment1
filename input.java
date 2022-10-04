import java.util.Scanner;
import java.util.Stack;

public class input {

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter the numeric expression you would like to evaluate: ");
            Scanner input = new Scanner(System.in);
            String expression = input.next();
            if (isValid(expression)) {
                String postfix = convertToPostfix(expression);
                System.out.println(postfix);
            } else {
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
        if (isOperator(exp.charAt(0)))
            return false;
        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                lastChar = c;
            } else if (isOperator(c)) {
                if (isOperator(lastChar))
                    return false;
                else
                    lastChar = c;
            } else
                return false;
        }
        if (isOperator(exp.charAt(n)))
            return false;
        return true;
    }

    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (isOperator(c)) {
                postfix.append(' ');
                while (!stack.isEmpty() && c >= stack.peek()) {// + -* 42 45 41, - *+ 45 41 42, * +- 41 42 45
                    postfix.append(stack.pop());
                    postfix.append(' ');
                }
                stack.push(c);
            }
        }
        postfix.append(' ');
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
            postfix.append(' ');
        }
        return postfix.toString();
    }

    public static boolean isOperator(char c) {
        if (c == '+' | c == '-' | c == '*')
            return true;
        else
            return false;
    }
}