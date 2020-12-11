package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class stringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource({"'',0 ", "'1',1", "'1,2',3", "'1,2,3,4',10"})
    public void addReturnsSum(String numbers, int expected) {
        assertEquals(expected, calculator.Add(numbers));
    }

    @Test
    public void canHandleNewLinesBetweenDigits() {
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

    @ParameterizedTest
    @CsvSource({"'//[*****]\n1*****2*****3',6", "'//[!!!]\n1!!!2!!!3',6"})
    public void delimitersCanBeOfAnyLength(String numbers, int expected) {
        Assertions.assertEquals(expected, calculator.anyLength(numbers));
    }

    @Test
    public void delimitersCanBeTwo() {
        String numbers = "//[*][%]\n1*2%3";
        Assertions.assertEquals(6, calculator.multipleDelim(numbers));
    }

    @Test
    public void delimitersCanBeMoreThanTwo() {
        String numbers = "//[*][%][?][a]\n1*2%3?1a3";
        Assertions.assertEquals(10, calculator.multipleDelim(numbers));
    }

    @Test
    public void delimitersCanBeMoreThanTwoAndOfAnyLength() {
        String numbers = "//[**][%%][??][aa]\n1**2%%3??1aa3";
        Assertions.assertEquals(10, calculator.multipleAnyLength(numbers));
    }
}

