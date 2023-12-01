package Table;
import java.io.SequenceInputStream;
import java.util.Random;
import java.util.Scanner;


public class Zad2 {

    // Wypełnianie tablicy wartościami losowymi z podanego przedziału
    static int[][] wypelnijTablice(int[][] t, int min, int max) {
        Random rand = new Random();

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = rand.nextInt(max - min + 1) + min;
            }
        }

        return t;
    }

    // Wypełnianie tablicy jedynkami na przekątnych, zerami w pozostałych miejscach
    static int[][] wypelnijTabliceZJedynkami(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i == j || i + j == t.length - 1) {
                    t[i][j] = 1;
                } else {
                    t[i][j] = 0;
                }
            }
        }

        return t;
    }

    // Transpozycja tablicy przez skopiowanie wartości do nowej tablicy
    static int[][] transponujTablice1(int[][] t) {
        int rows = t.length;
        int cols = t[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                transposed[i][j] = t[j][i];
            }
        }

        return transposed;
    }

    // Transpozycja tablicy przez przestawianie elementów wewnątrz tablicy
    static int[][] transponujTablice2(int[][] t) {
        int n = t.length;

        // Sprawdzenie, czy tablica jest kwadratowa
        for (int i = 0; i < n; i++) {
            if (t[i].length != n) {
                System.out.println("Tablica nie jest kwadratowa. Zwracam null.");
                return null;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Zamiana elementów symetrycznych względem głównej przekątnej
                int temp = t[i][j];
                t[i][j] = t[j][i];
                t[j][i] = temp;
            }
        }

        return t;
    }

    // Mnożenie macierzy
    static int[][] mnozenieMacierzy(int[][] A, int[][] B) {
        int rowsA = A.length-1;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj rozmiar macierzy A oddzielone spacja");
        String matrixASize = input.nextLine();
        System.out.println("Podaj rozmiar macierzy B oddzielone spacja");
        String matrixBSize = input.nextLine();
        matrixASize += " " + matrixBSize;
        String[] matrixSize = matrixASize.split(" ", 4);
        int[][] macierzA = new int[Integer.parseInt(matrixSize[0])][Integer.parseInt(matrixSize[1])];
        int[][] macierzB = new int[Integer.parseInt(matrixSize[2])][Integer.parseInt(matrixSize[3])];

        wypelnijTablice(macierzA, 1, 10);
        wypelnijTablice(macierzB, 1, 10);

        System.out.println("Macierz A:");
        wypiszTablice(macierzA);

        System.out.println("Macierz B:");
        wypiszTablice(macierzB);

        System.out.println("Transpozycja Macierzy A (metoda 1):");
        int[][] transponowanaA1 = transponujTablice1(macierzA);
        wypiszTablice(transponowanaA1);

        System.out.println("Transpozycja Macierzy B (metoda 1):");
        int[][] transponowanaB1 = transponujTablice1(macierzB);
        wypiszTablice(transponowanaB1);

        System.out.println("Transpozycja Macierzy A (metoda 2):");
        int[][] transponowanaA2 = transponujTablice2(macierzA);
        if (transponowanaA2 != null) {
            wypiszTablice(transponowanaA2);
        }

        System.out.println("Transpozycja Macierzy B (metoda 2):");
        int[][] transponowanaB2 = transponujTablice2(macierzB);
        if (transponowanaB2 != null) {
            wypiszTablice(transponowanaB2);
        }

        System.out.println("Wynik mnożenia macierzy A i B:");
        int[][] wynikMnozenia = mnozenieMacierzy(macierzA, macierzB);
        wypiszTablice(wynikMnozenia);
    }

    // Funkcja pomocnicza do wypisywania tablicy
    static void wypiszTablice(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.print(t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

