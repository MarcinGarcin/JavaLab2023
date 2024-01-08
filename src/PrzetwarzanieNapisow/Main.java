package PrzetwarzanieNapisow;

import java.util.Scanner;

public class Main{

    static String odwrócony(String napis) {
        String end = "";
        char[] sliced = napis.toCharArray();
        char[] tmp = new char[sliced.length];
        for (int i = 0; i < sliced.length; i++) {
            tmp[i] = sliced[sliced.length-1-i];
        }
        for (char letter : tmp) {
            end = end + letter;
        }
        return end;
    }
    static String przestawioneSlowa(String napis){
        String end = "";
        String[] sliced = napis.split(" ");
        String[] tmp = new String[sliced.length];
        for (int i = 0; i < sliced.length; i++) {
            tmp[i] = sliced[sliced.length-1-i];
        }
        for (String letter : tmp) {
            end = end + letter + " ";
        }
        return end;
    }
    static String szyfruj(String napis, int klucz) {
        String end ="";
        char[] alphabet = {'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'ł', 'm', 'n', 'ń', 'o', 'p', 'r', 's', 't',
                'u', 'w', 'y', 'z', 'ź', 'ż'};
        char[] origin = napis.toCharArray();
        // utworzenie zmiennej do sprawdzania czy litera jest dużą
        boolean bigSize;
        for (char letterO : origin) {
            bigSize = Character.isUpperCase(letterO);
            int i = 0;
            for (char letterA : alphabet) {
                if (letterO == letterA) {
                    int newPosition = (i - klucz + alphabet.length) % alphabet.length;
                    if (bigSize) {
                        end = end + Character.toUpperCase(alphabet[newPosition]);
                    } else
                        end = end + alphabet[newPosition];;
                }
                i++;
            }
        }
        return end;
    }
    static String odszyfruj(String napis, int klucz) {
        String end = "";
        char[] alphabet = {'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę', 'f', 'g', 'h', 'i',
                'j', 'k', 'l', 'ł', 'm', 'n', 'ń', 'o', 'p', 'r', 's', 't',
                'u', 'w', 'y', 'z', 'ź', 'ż'};
        char[] origin = napis.toCharArray();
        // utworzenie zmiennej do sprawdzania czy litera jest dużą
        boolean bigSize;
        for (char letterO : origin) {
            bigSize = Character.isUpperCase(letterO);
            int i = 0;
            for (char letterA : alphabet) {
                if (letterO == letterA) {
                    int newPosition = (i + klucz + alphabet.length) % alphabet.length;
                    if (bigSize) {
                        end = end + Character.toUpperCase(alphabet[newPosition]);
                    } else
                        end = end + alphabet[newPosition];
                }
                i++;
            }
        }
        return end;
    }
    static String uporzadkuj(String napis) {
        String ending;
        StringBuilder result = new StringBuilder();
        boolean lastCharWasSpace = false;

        for (char c : napis.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (!lastCharWasSpace) {
                    result.append(' ');
                }
                lastCharWasSpace = true;
            } else if (c == '.' || c == ',' || c == ';' || c == ':' || c == '!' || c == '?') {
                if (!lastCharWasSpace) {
                    result.append(' ');
                }
                result.append(c);
                lastCharWasSpace = true;
            } else {
                result.append(c);
                lastCharWasSpace = false;
            }
        }
        ending = result.toString().trim();
        return ending;
    }
    static int liczbaWystapien(String napis, char znak){
        char[] calyNapis = napis.toCharArray();
        int numberOfExists = 0;
        for(char letter: calyNapis){
            if(letter == znak){
                numberOfExists += + 1;
            }
        }
        return numberOfExists;
    }
    static int[] histogram(String napis) {
        int[] counts = new int[26];

        for (char c : napis.toUpperCase().toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                counts[c - 'A']++;
            }
        }
        return counts;
    }
    static boolean palindrom(String napis){
        String palindrom = "";
        char[] main = napis.toCharArray();
        for(int i = napis.length()-1; i>-1; i--){
            palindrom += main[i];
        }
        if(palindrom.equals(napis)){
            return true;
        }
        else{
            return false ;
        }
    }
    static boolean anagram(String napis,String napis1){
        String anagram = "";
        char[] main = napis1.toCharArray();
        for(int i = napis1.length()-1; i>-1; i--){
            anagram += main[i];
        }
        if(anagram.equals(napis)){;
            return true;

        }
        else{
            return false ;
        }
    }




    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Wybierz jakiej funkcji chcesz użyć");
            System.out.println("1. Odwrócenie kolejnosci liter");
            System.out.println("2. Odwrócenie kolejnosci słow");
            System.out.println("3. Szyfrowanie Cezara");
            System.out.println("4. Odkodowanie szyfru Cezara");
            System.out.println("5. Uporządkowanie zdania");
            System.out.println("6. Znajdywanie ilości znaków w zdaniach");
            System.out.println("7. Wykonać histogram dla tekstu");
            System.out.println("8. Sprawdzenie czy słowo jest palindromem");
            System.out.println("9. Sprawdzenie czy słowo jest anagramem");
            System.out.println("10. Koniec");
            choice = input.nextInt();
            String trash = input.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Napisz słowo które chcesz odwrócić");
                    String word = input.nextLine();
                    System.out.println(odwrócony(word));
                    System.out.println("\n");
                    break;
                }
                case 2: {
                    System.out.println("Napisz zdanie które chcesz odwrócić");
                    String word = input.nextLine();
                    System.out.println(przestawioneSlowa(word));
                    System.out.println("\n");
                    break;
                }
                case 3: {
                    System.out.println("Napisz słowo które chcesz zaszyfrować");
                    String word = input.nextLine();
                    System.out.println("Napisz klucz jakim kod ma być zaszyfrowany,wyłącznie liczba całkowita");
                    int code = input.nextInt();
                    System.out.println(szyfruj(word, code));
                    System.out.println("\n");
                    break;
                }
                case 4: {
                    System.out.println("Napisz słowo które chcesz odszyfrować");
                    String word = input.nextLine();
                    System.out.println("Napisz klucz jakim kod ma być odszyfrowany,wyłącznie liczba całkowita");
                    int code = input.nextInt();
                    input.nextLine();
                    System.out.println(odszyfruj(word, code));
                    System.out.println("\n");
                    break;
                }
                case 5: {
                    System.out.println("Napisz zdanie które chcesz uporządkować");
                    String word = input.nextLine();
                    System.out.println(uporzadkuj(word));
                    System.out.println("\n");
                    break;
                }
                case 6: {
                    System.out.println("Napisz słowo które chcesz sprawdzać");
                    String word = input.nextLine();
                    System.out.println("Napisz znak którego będziesz szukać");
                    char znak = input.next().charAt(0);
                    System.out.println(liczbaWystapien(word, znak));
                    System.out.println("\n");
                    break;
                }
                case 7: {
                    System.out.println("Napisz tekst dla którego chcesz wykonać histogram");
                    String word = input.nextLine();
                    int[] counts = histogram(word);
                    for (int i = 0; i < counts.length; i++) {
                        char letter = (char) ('A' + i);
                        System.out.println(letter + ": " + counts[i]);
                    }
                        break;
                }
                case 8: {
                    System.out.println("Napisz słowo które chcesz sprawdzić czy jest palindromem");
                    String word = input.nextLine();
                    System.out.println(palindrom(word));
                    System.out.println("\n");
                    break;
                }
                case 9:{
                    System.out.println("Napisz pierwsze slowo");
                    String word = input.nextLine();
                    System.out.println("Napisz słowo ktore ma byc sprawdzone pod kątem bycia anagramem");
                    String word1 = input.nextLine();
                    System.out.println(anagram(word, word1));
                    System.out.println("\n");
                    break;

                }
                case 10:{
                    break;
                }
                default:
                    System.out.println("Wybierz podaną opcje");
            }
        }while(choice !=10) ;
    }
}



