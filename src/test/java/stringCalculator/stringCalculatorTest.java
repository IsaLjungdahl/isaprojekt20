package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class stringCalculatorTest {
    @Test
    public void doesStringCalculatorExist(){
        StringCalculator calculator=new StringCalculator();
        assertTrue(calculator.add());
    }
    @Test
    public void calculatorReturnsZeroWhenEmptyString(){
        StringCalculator calculator=new StringCalculator();
        String numbers="";
        assertEquals(0,calculator.add(numbers));
    }
}
