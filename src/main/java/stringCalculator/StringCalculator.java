package stringCalculator;

public class StringCalculator {
    public boolean Add() {
        return true;
    }

    public int Add(String numbers) {
        if(numbers.isEmpty()){
        return 0;}
        return Integer.parseInt(numbers);
    }
}
