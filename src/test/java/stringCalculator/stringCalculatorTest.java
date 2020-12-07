package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class stringCalculatorTest {
    @Test
    public void doesStringCalculatorExist(){
        StringCalculator calculator=new StringCalculator();
        assertTrue(calculator.add());
    }
}
