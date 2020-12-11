package stringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {


    public int Add(String numbers) {
        if (numbers.equals("")) return 0;
        ArrayList<Integer> negative = new ArrayList<>();
        String[] stringArr = numbers.split(",");
        int[] intArr = Arrays.stream(stringArr).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < intArr.length; i++) {

            if (intArr[i] < 0) negative.add(intArr[i]);

            if (intArr[i] > 1000) intArr[i] = 0;
        }

        if (negative.size() >= 1) throw new IllegalArgumentException("negatives not allowed " + negative);

        return Arrays.stream(intArr).sum();
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


    int anyLength(String numbers) {

        String delimiter = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
        numbers = numbers.substring(numbers.indexOf('\n') + 1);
        numbers = numbers.replaceAll(";", ",");
        String[] diff = numbers.split(escapeSpecialRegexChars(delimiter));
        int res = 0;
        for (String number : diff) {
            res += (Integer.parseInt(number));
        }

        return res;
    }

    int multipleAnyLength(String numbers) {
        ArrayList<String> delimArr = new ArrayList<>();
        String delimiter = numbers.substring(numbers.indexOf("["), numbers.lastIndexOf("]") + 1);
        delimArr.add(delimiter);
//        String delimiter = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("]"));
        numbers = numbers.substring(numbers.indexOf('\n') + 1);
        numbers = numbers.replaceAll(delimArr.toString(), ",");
        String[] diff = numbers.split(escapeSpecialRegexChars(",,"));
        int res = 0;
        for (String number : diff) {
            res += (Integer.parseInt(number));
        }

        return res;
    }

    private String escapeSpecialRegexChars(String str) {
        Pattern specRegexChars = Pattern.compile("\\*");
        return specRegexChars.matcher(str).replaceAll("\\\\*");
    }

    public int multipleDelim(String numbers) {
        ArrayList<String> delimArr = new ArrayList<>();
        String delimiter = numbers.substring(numbers.indexOf("["), numbers.lastIndexOf("]") + 1);
        delimArr.add(delimiter);

        numbers = numbers.substring(numbers.indexOf('\n') + 1);

        numbers = numbers.replaceAll(delimArr.toString(), ",");

        String[] diff = numbers.split("[ ,\n]");

        int res = 0;
        for (String number : diff) {
            res += Integer.parseInt(number);
        }
        return res;
    }
}








