package IITermin2012;


import java.util.Random;

public class Zad_1A {
    public static void main(String[] args) {
        Random rand = new Random();

        // Wylosuj parzystą liczbę z zakresu <10; 20)
        int rozmiar = rand.nextInt(6) * 2 + 10;

        // Utwórz kwadratową tablicę o rozmiarze rozmiar x rozmiar
        double[][] tablica = new double[rozmiar][rozmiar];

        // Wypełnij tablicę zgodnie z warunkami
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                if (i == j) {  // Główna przekątna
                    tablica[i][j] = rand.nextDouble();  // Losuj liczbę ułamkową < 1
                } else if (i + j == rozmiar - 1) {  // Druga przekątna
                    tablica[i][j] = rand.nextDouble() + 2;  // Losuj liczbę mieszana > 1
                }
                // Jedynka jest pomijana, więc zostaje wartość domyślna 0.0
            }
        }

        // Wyświetl tablicę
        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                System.out.printf("%.2f\t", tablica[i][j]);  // Zaokrągl do dwóch miejsc po przecinku
            }
            System.out.println();  // Nowy wiersz

        }
    }
}