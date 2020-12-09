package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringCalculator {


    public boolean Add() {
        return true;
    }

    public int Add(String numbers) throws Exception {
        if (numbers.equals("")) return 0;
        String[] stringArr = numbers.split("[^-0-9]");

        int[] intArr = Arrays.stream(stringArr).mapToInt(s -> Integer.parseInt(s)).toArray();

        ArrayList<Integer> negative = new ArrayList<>();
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] < 0) {
                negative.add(intArr[i]);
            }
            if(intArr[i]>1000) {
                intArr[i]=0;
            }
        }
        if (negative.size() >= 1) {
            throw new Exception("negatives not allowed " + negative);

        }

        int sum = Arrays.stream(intArr).sum();
        return sum;
    }
}
