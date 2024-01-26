package IITermin2014;

public class A2 {
    private static double[][] skoki(double tab[][], int K, int P) {
        for (double[] skoczek : tab) {
            double liczbaPunktow = 0;
            double dlugoscSkoku;
            dlugoscSkoku = skoczek[1] - K;
            if (dlugoscSkoku >= 0) {
                liczbaPunktow += 60;
            } else {
                liczbaPunktow -= Math.floor(dlugoscSkoku) * -P;
            }
            double sumaOcen = 0;
            double max = 0;
            double min = 10000;
            for (int i = 2; i < 8; i++) {
                sumaOcen += skoczek[i];
                if (max < skoczek[i]) {
                    max = skoczek[i];
                }
                if (min > skoczek[i]) {
                    min = skoczek[i];
                }
            }
            liczbaPunktow = liczbaPunktow + (sumaOcen - (max + min));
            skoczek[8] = liczbaPunktow;


        }
        return tab;
    }
    public static void main(String[] args) {
        double[][] skoczkowie = {
                {1, 120.5, 18.5, 18.0, 19.0, 17.5, 18.5, 18.0, 0},
                {2, 115.0, 17.0, 17.5, 16.5, 18.0, 16.0, 17.0, 0},
                {3, 122.0, 19.0, 18.5, 20.0, 18.0, 19.5, 18.5, 0},
                {4, 110.5, 16.0, 16.5, 15.5, 17.0, 15.0, 16.0, 0},
                {5, 130.0, 20.0, 19.5, 20.5, 19.0, 20.0, 19.5, 0},
                {6, 118.0, 18.0, 17.5, 18.5, 17.0, 18.0, 18.5, 0},
                {7, 125.5, 19.5, 19.0, 20.0, 18.5, 19.0, 19.0, 0},
                {8, 112.5, 17.5, 17.0, 16.0, 17.0, 16.5, 17.0, 0},
                {9, 128.0, 20.0, 19.5, 19.0, 20.0, 19.5, 19.0, 0},
                {10, 115.5, 17.5, 18.0, 17.0, 17.5, 17.0, 17.5, 0}
        };
        double[][] wyniki = skoki(skoczkowie,120,5);
        for (double[] skoczek : wyniki) {
            for(double  dbl : skoczek){
                System.out.print(dbl+", ");
            }
            System.out.println();
        }
        }


    }

