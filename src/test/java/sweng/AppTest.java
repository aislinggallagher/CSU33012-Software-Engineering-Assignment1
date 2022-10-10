package sweng;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
 
public class AppTest 
{
    
    @Test
    public void isValidTestTrue() {
        boolean valid = App.isValid("1+2+3");
        assertEquals(true, valid);
    }
    @Test
    public void isValidTestFalse() {
        boolean valid = App.isValid("hi there");
        assertEquals(false, valid);
    }
    @Test
    public void convertToPostfixTest() {
        String postfix = App.convertToPostfix("2+3+4");
        String correctPostfix = "2 3 + 4 + ";
        assertEquals(correctPostfix, postfix);
    }
    @Test
    public void evalPostfixTest() {
        String result = App.evaluatePostfix("2 3 + 4 +");
        String correct = "9";
        assertEquals(correct, result);
    }
    @Test
    public void isOperatorTest() {
        boolean result = App.isOperator('+');
        assertEquals(true, result);
    }
}

