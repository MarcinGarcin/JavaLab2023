package PlikiTekstowe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Zad1 {
    private static List<Integer> generateRandomNumbers(int count) {
        List<Integer> numbers = new ArrayList<Integer>();
        Random randomNumbers = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(randomNumbers.nextInt(1000));
        }
        return numbers;
    }

    private static void writeNumbersToFile(List<Integer> numbers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Integer number : numbers) {
                writer.write(number.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private static double averageNumber(List<Integer> numbers){
        int sum = 0;
        for(Integer number : numbers){
            sum += number;
        }
        return (double) sum/numbers.size();
    }
    private static List<Integer> higherThanAverage(double average, List<Integer> numbers) {
        List<Integer> numberHigherThanAverage = new ArrayList<>();
        for (Integer number : numbers) {
            if (number > average) {
                numberHigherThanAverage.add(number);
            }
        }
        return numberHigherThanAverage;

    }
    private static List<Integer> lowerThanAverage(double average, List<Integer> numbers) {
        List<Integer> numberLowerThanAverage = new ArrayList<>();
        for (Integer number : numbers) {
            if (number < average) {
                numberLowerThanAverage.add(number);
            }
        }
        return numberLowerThanAverage;
    }


    public static void main(String[] args) {
        List<Integer> allNumbers = generateRandomNumbers(1000);
        double average = averageNumber(allNumbers);
        List<Integer> higherThanAverageNumbers = higherThanAverage(average,allNumbers);
        List<Integer> lowerThanAverageNumbers = lowerThanAverage(average,allNumbers);

        writeNumbersToFile(allNumbers , "allNumbers");
        writeNumbersToFile(higherThanAverageNumbers , "higherThanAverageNumbers");
        writeNumbersToFile(lowerThanAverageNumbers , "lowerThanAverageNumbers");
    }
}
