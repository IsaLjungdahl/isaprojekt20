package stringCalculator;

public class StringCalculator {
    public boolean Add() {
        return true;
    }

    public int Add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else if(numbers.length()<2){
            return Integer.parseInt(numbers);
        }
        String[]numberArr =numbers.split(",");
        int sum= Integer.parseInt(numberArr[0])+Integer.parseInt(numberArr[1]);
        return sum;
    }
}
