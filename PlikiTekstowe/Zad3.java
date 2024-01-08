package PlikiTekstowe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Zad3 {

    private static List<String> readLinesFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        return lines;
    }

    private static List<String[]> splitLinesToWords(List<String> lines) {
        List<String[]> linesWithSplittedWords = new ArrayList<>();
        for (String line : lines) {
            String[] splittedWords = line.split(" ");
            linesWithSplittedWords.add(splittedWords);
        }
        return linesWithSplittedWords;
    }

    private static int countWords(List<String[]> linesWithSplittedWords) {
        int sum = 0;
        for (String[] words : linesWithSplittedWords) {
            sum += words.length;
        }
        return sum;
    }

    private static int averageSentenceLength(List<String> linesFromFile) {
        int amountOfLetters = 0;
        int amountOfDots = 0;
        for (String line : linesFromFile) {
            String strippedLine = line.replaceAll("\\s", "");
            amountOfLetters += strippedLine.length();
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '.') {
                    amountOfDots++;
                }
            }
        }
        return amountOfLetters / Math.max(1, amountOfDots);
    }

    public static void main(String[] args) {
        List<String> linesFromFile = readLinesFromFile("slowa");
        List<String[]> splittedLinesFromFile = splitLinesToWords(linesFromFile);
        int amountOfWords = countWords(splittedLinesFromFile);
        int averageLength = averageSentenceLength(linesFromFile);

        System.out.println("Ilość słów to " + amountOfWords + " słów");
        System.out.println("Średnia długość zdania to " + averageLength + " znaków");
    }
}
