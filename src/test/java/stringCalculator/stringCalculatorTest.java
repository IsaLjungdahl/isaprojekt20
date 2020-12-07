package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class stringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void doesStringCalculatorExist(){
        assertTrue(calculator.Add());
    }
    @Test
    public void addReturnsZeroWhenEmptyString(){
        String numbers="";
        assertEquals(0,calculator.Add(numbers));
    }
    @Test
    public void addReturnsJustOneNumber(){
        String numbers="1";

        Assertions.assertEquals(1,calculator.Add(numbers));
    }
    @Test
    public void addReturnsSumOfTwoNumbers(){
        String numbers="1,2";

        Assertions.assertEquals(3,calculator.Add(numbers));

    }
    @Test
    public void addReturnsSumOfMoreThanTwoNumbers(){
        String numbers="1,2,3,4";

        Assertions.assertEquals(10, calculator.Add(numbers));

    }
    @Test
    public void addCanHandleNewLinesBetweenDigits(){
        String numbers="1\n2,3";
        Assertions.assertEquals(6, calculator.Add(numbers));

    }
}
