package zerowka;

import java.io.*;

public class Main {

        public static int odwrocIDodajLiczby(String nazwaPlikuBezRozszerzenia) {
            String nazwaPlikuBinarnego = nazwaPlikuBezRozszerzenia + ".bin";
            String nazwaPlikuTekstowego = nazwaPlikuBezRozszerzenia + ".txt";

            try {
                RandomAccessFile plikBinarny = new RandomAccessFile(nazwaPlikuBinarnego, "rw");
                BufferedReader plikTekstowy = new BufferedReader(new FileReader(nazwaPlikuTekstowego));

                odwrocPlikBinarny(plikBinarny);

                int sum = dodajLiczbyZPlikuTXT(plikBinarny, plikTekstowy);
                plikBinarny.close();
                plikTekstowy.close();

                return sum;
            } catch (IOException e) {
                e.printStackTrace();
                return -1;
            }
        }

        private static void odwrocPlikBinarny(RandomAccessFile plik) throws IOException {
            long dlugosc = plik.length();
            byte[] bufor = new byte[8];

            for (long i = 0, j = dlugosc - 8; i < j; i += 8, j -= 8) {
                plik.seek(i);
                plik.readFully(bufor);
                plik.seek(j);
                plik.write(bufor);
                plik.readFully(bufor);
                plik.seek(i);
                plik.write(bufor);
            }
        }

        private static int dodajLiczbyZPlikuTXT(RandomAccessFile plikBinarny, BufferedReader czytnikTekstu)
                throws IOException {
            String line;
            int sum = 0;

            while ((line = czytnikTekstu.readLine()) != null) {
                int number = Integer.parseInt(line);
                plikBinarny.writeInt(number);
                sum += number;
            }

            return sum;
        }

        public static void main(String[] args) {
            String nazwaPlikuBezRozszerzenia = "PLIK";

            int wynik = odwrocIDodajLiczby(nazwaPlikuBezRozszerzenia);

            if (wynik != -1) {
                System.out.println("Suma liczb zapisanych w pliku BIN: " + wynik);
            } else {
                System.out.println("Błąd podczas manipulacji plikami.");
            }
        }
    }

