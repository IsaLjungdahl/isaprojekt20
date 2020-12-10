package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {


    public boolean Add() {
        return true;
    }

    public int Add(String numbers) {

        if (numbers.equals("")) return 0;


        String[] stringArr = numbers.split(",");

        int[] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();


        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] < 0) {
                negative.add(intArr[i]);
            }
            if (intArr[i] > 1000) {
                intArr[i] = 0;
            }
        }
        if (negative.size() >= 1) {
            throw new IllegalArgumentException("negatives not allowed " + negative);

        }

        int sum = Arrays.stream(intArr).sum();
        return sum;
    }

    int newLines(String numbers) {
        String[] diff = numbers.split("[,\n]");
        int res = 0;
        for (String number : diff) {
            res += (Integer.parseInt(number));
        }

        return res;
    }

    int diffDelim(String numbers) {
        numbers = numbers.substring(numbers.indexOf(';') + 1);
        numbers = numbers.replaceAll(";", ",");
        String[] diff = numbers.split("[,\n]");
        int res = 0;
        for (String number : diff) {
            res += (Integer.parseInt(number));
        }
        return res;
    }
}






