package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class stringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    public void doesStringCalculatorExist() {
        assertTrue(calculator.Add());
    }

    @Test
    public void addReturnsZeroWhenEmptyString() throws Exception {
        String numbers = "";
        assertEquals(0, calculator.Add(numbers));
    }

    @Test
    public void addReturnsJustOneNumber() throws Exception {
        String numbers = "1";

        Assertions.assertEquals(1, calculator.Add(numbers));
    }

    @Test
    public void addReturnsSumOfTwoNumbers() throws Exception {
        String numbers = "1,2";

        Assertions.assertEquals(3, calculator.Add(numbers));

    }

    @Test
    public void addReturnsSumOfMoreThanTwoNumbers() throws Exception {
        String numbers = "1,2,3,4";

        Assertions.assertEquals(10, calculator.Add(numbers));

    }

    @Test
    public void addCanHandleNewLinesBetweenDigits() throws Exception {
        String numbers = "1\n2,3";
        Assertions.assertEquals(6, calculator.Add(numbers));

    }

    @Test
    public void addSupportsDifferentDelimiters() throws Exception {
        String numbers =//[delimiter]\n[numbers…]
                "1\n2,3";
        Assertions.assertEquals(6, calculator.Add(numbers));
    }

    @Test
    public void negativesNotAllowed() {
        String numbers="-1,2,3";
        Exception e = assertThrows(
                Exception.class, () -> calculator.Add(numbers));


        assertThat(e).hasMessage("negatives not allowed [-1]");
    }
    @Test
    public void multipleNegativesNotAllowed() {
        String numbers=//[delimiter]\n[numbers…]
                "-1,-2,-3";
        Exception e = assertThrows(
                Exception.class, () -> calculator.Add(numbers));


        assertThat(e).hasMessage("negatives not allowed [-1, -2, -3]");
    }

}

