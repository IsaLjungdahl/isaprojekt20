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
        int[] intArr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            intArr[i] = Integer.parseInt(stringArr[i]);
        }
        int sum = 0;
        for (int i : intArr) {
            sum += i;
        }
        return sum;
    }
}
