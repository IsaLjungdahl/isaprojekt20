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
    public void addReturnsZeroWhenEmptyString() {
        String numbers = "";
        assertEquals(0, calculator.Add(numbers));
    }

    @Test
    public void addReturnsJustOneNumber() {
        String numbers = "1";

        assertEquals(1, calculator.Add(numbers));
    }

    @Test
    public void addReturnsSumOfTwoNumbers() {
        String numbers = "1,2";

        assertEquals(3, calculator.Add(numbers));

    }

    @Test
    public void addReturnsSumOfMoreThanTwoNumbers() {
        String numbers = "1,2,3,4";

        assertEquals(10, calculator.Add(numbers));

    }

    @Test
    public void addCanHandleNewLinesBetweenDigits() {
        String numbers = "1\n2,3";
        assertEquals(6, calculator.newLines(numbers));

    }

    @Test
    public void addSupportsDifferentDelimiters() {
        String numbers = "//;1\n2,3";
        assertEquals(6, calculator.diffDelim(numbers));
    }

    @Test
    public void negativesNotAllowed() {
        String numbers = "-1,2,3";
        Exception e = assertThrows(
                Exception.class, () -> calculator.Add(numbers));


        assertThat(e).hasMessage("negatives not allowed [-1]");
    }

    @Test
    public void multipleNegativesNotAllowed() {
        String numbers = "-1,-2,-3";
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> calculator.Add(numbers));


        assertThat(e).hasMessage("negatives not allowed [-1, -2, -3]");
    }

    @Test
    public void ignoreNumberOverThousand() {
        String numbers = "1001,2,2000";
        assertEquals(2, calculator.Add(numbers));
    }
    @Test
    public void delimitersCanBeOfAnyLength()  {
    String numbers = "//[*****]\n1*****2*****3";
       Assertions.assertEquals(6, calculator.anyLength(numbers));
 }
    @Test
    public void delimitersCanBeOfAnyLengthTwo()  {
        String numbers = "//[!!!!!]\n1!!!!!2!!!!!3";
        Assertions.assertEquals(6, calculator.anyLength(numbers));
    }
//    Allow multiple delimiters like this: “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
//
    @Test
    public void delimitersCanBeTwo(){
        String numbers="//[*][%]\n1*2%3";
        Assertions.assertEquals(6, calculator.multipleDelim(numbers));
    }
    @Test
    public void delimitersCanBeMoreThanTwo(){
        String numbers="//[*][%][?][a]\n1*2%3?1a3";
        Assertions.assertEquals(10, calculator.multipleDelim(numbers));
    }

    @Test
    public void delimitersCanBeMoreThanTwoAndOfAnyLength(){
        String numbers="//[**][%%][??][aa]\n1**2%%3??1aa3";
        Assertions.assertEquals(10, calculator.multipleAnyLength(numbers));
    }
//Step 9
//Make sure you can also handle multiple delimiters with length longer than one char.

}

