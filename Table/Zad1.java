package Table;
import java.util.Scanner;

public class Zad1 {

    static double det2(double[][] macierz) {
        // Obliczanie wyznacznika macierzy 2x2
        return macierz[0][0] * macierz[1][1] - macierz[0][1] * macierz[1][0];
    }

    static double det3(double[][] macierz) {
        // Obliczanie wyznacznika macierzy 3x3
        return macierz[0][0] * (macierz[1][1] * macierz[2][2] - macierz[1][2] * macierz[2][1])
                - macierz[0][1] * (macierz[1][0] * macierz[2][2] - macierz[1][2] * macierz[2][0])
                + macierz[0][2] * (macierz[1][0] * macierz[2][1] - macierz[1][1] * macierz[2][0]);
    }

    static void rozwiazUklad(double[][] wspolczynniki, double[] stale) {
        double[][] macierz = new double[2][2];

        // Inicjalizacja macierzy współczynników
        macierz[0][0] = wspolczynniki[0][0];
        macierz[0][1] = wspolczynniki[0][1];
        macierz[1][0] = wspolczynniki[1][0];
        macierz[1][1] = wspolczynniki[1][1];

        double wyznacznikWspolczynnikow = det2(macierz);

        // Sprawdzenie czy układ jest rozwiązywalny (niezerowy wyznacznik)
        if (wyznacznikWspolczynnikow != 0) {
            // Utworzenie macierzy dla x i y z wyrazami wolnymi
            double[][] macierzX = new double[2][2];
            double[][] macierzY = new double[2][2];

            // Podstawienie stałych do macierzy
            macierzX[0][0] = stale[0];
            macierzX[0][1] = wspolczynniki[0][1];
            macierzX[1][0] = stale[1];
            macierzX[1][1] = wspolczynniki[1][1];

            macierzY[0][0] = wspolczynniki[0][0];
            macierzY[0][1] = stale[0];
            macierzY[1][0] = wspolczynniki[1][0];
            macierzY[1][1] = stale[1];

            // Obliczenie wyznaczników dla x i y
            double wyznacznikX = det2(macierzX);
            double wyznacznikY = det2(macierzY);

            // Obliczenie rozwiązań
            double x = wyznacznikX / wyznacznikWspolczynnikow;
            double y = wyznacznikY / wyznacznikWspolczynnikow;

            System.out.println("Rozwiązanie układu równań:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        } else {
            System.out.println("Układ równań jest niesprzeczny lub nieoznaczony.");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Pobranie współczynników od użytkownika
        System.out.println("Podaj współczynniki układu równań (A1 B1 A2 B2):");
        double[][] wspolczynniki = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                wspolczynniki[i][j] = input.nextDouble();
            }
        }

        // Pobranie stałych od użytkownika
        System.out.println("Podaj stałe układu równań (C1 C2):");
        double[] stale = new double[2];
        for (int i = 0; i < 2; i++) {
            stale[i] = input.nextDouble();
        }

        // Rozwiązanie układu równań
        rozwiazUklad(wspolczynniki, stale);

        input.close();
    }
}