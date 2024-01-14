package IITermin2012;


import java.util.Random;

public class Zad_A1 {
    public static void main(String[] args) {
        Random rand = new Random();

        int rozmiar = rand.nextInt(6) * 2 + 10;
        double[][] tablica = new double[rozmiar][rozmiar];


        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                if (i == j) {
                    tablica[i][j] = rand.nextDouble();  //
                } else if (i + j == rozmiar - 1) {  //
                    tablica[i][j] = rand.nextDouble() + 1;
                }
            }
        }

        for (int i = 0; i < rozmiar; i++) {
            for (int j = 0; j < rozmiar; j++) {
                System.out.printf("%.22f\t", tablica[i][j]);
            }
            System.out.println();

        }
    }
}