package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class stringCalculatorTest {
    @Test
    public void doesStringCalculatorExist(){
        StringCalculator calculator=new StringCalculator();
        assertTrue(calculator.Add());
    }
    @Test
    public void calculatorReturnsZeroWhenEmptyString(){
        StringCalculator calculator=new StringCalculator();
        String numbers="";
        assertEquals(0,calculator.Add(numbers));
    }
    @Test
    public void calculatorReturnsJustOneNumber(){
        StringCalculator calculator=new StringCalculator();
        String numbers="1";

        Assertions.assertEquals(1,calculator.Add(numbers));
    }
}
