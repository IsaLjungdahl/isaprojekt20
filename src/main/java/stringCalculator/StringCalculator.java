package stringCalculator;

import java.util.Arrays;

public class StringCalculator {
    public boolean Add() {
        return true;
    }

    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.length() < 2) {
            return Integer.parseInt(numbers);
        }
        String[] stringArr = numbers.split(",");
        int[] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(intArr).sum();
    }
}
