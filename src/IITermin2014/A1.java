package IITermin2014;

public class A1 {
        public static float liczbaF(String lancuch) {

            int znak_liczby = Integer.parseInt(Character.toString(lancuch.charAt(0)));

            int cecha = Integer.parseInt(lancuch.substring(1, 9), 2) - 127;

            float mantysa = 1.0f;
            for (int i = 9; i < 32; i++) {
                int bit = Integer.parseInt(lancuch.charAt(i) + "");
                mantysa += bit * Math.pow(2, -(i - 8));
            }

            float wynik = (float) (Math.pow(-1, znak_liczby) * mantysa * Math.pow(2, cecha));
            return wynik;
        }

        public static void main(String[] args) {
            String lanuchBinarny = "11000011001000000000000000000000";
            float wynik = liczbaF(lanuchBinarny);
            System.out.println(wynik);
        }
    }
