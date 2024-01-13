package PlikiDanych;

import java.io.*;

public class Main {

    public static int przetwarzajPlik(String nazwaPliku, String nazwaTowaru) {
        double rabat = 0.9;
        int liczbaSztuk = 0;

        try (
                DataInputStream dis = new DataInputStream(new FileInputStream(nazwaPliku));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("temp.txt"))
        ) {
            int linesAmount = 0;
            while (true) {
                try {
                    dis.readUTF();
                    dis.readDouble();
                    dis.readInt();
                    linesAmount++;
                } catch (EOFException e) {
                    break;
                }
            }

            // Resetowanie pozycji wskaźnika w strumieniu
            dis.close();
            DataInputStream dis2 = new DataInputStream(new FileInputStream(nazwaPliku));

            String[] towar = new String[linesAmount];
            double[] cena = new double[linesAmount];
            int[] sztuki = new int[linesAmount];

            // Wczytywanie danych do tablic
            for (int i = 0; i < linesAmount; i++) {
                towar[i] = dis2.readUTF();
                cena[i] = dis2.readDouble();
                sztuki[i] = dis2.readInt();

                // Zastosowanie rabatu dla danego towaru
                if (towar[i].equals(nazwaTowaru) && sztuki[i] >= 100) {
                    sztuki[i] = (int) (sztuki[i] * rabat);
                    liczbaSztuk = sztuki[i];
                }

                // Zapis przetworzonych danych do nowego pliku
                dos.writeUTF(towar[i]);
                dos.writeDouble(cena[i]);
                dos.writeInt(sztuki[i]);
            }

            dis2.close();
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Zamiana plików po zakończeniu przetwarzania
        File staryPlik = new File(nazwaPliku);
        File nowyPlik = new File("temp.txt");
        if (staryPlik.delete() && nowyPlik.renameTo(staryPlik)) {
            System.out.println("Przetwarzanie zakończone pomyślnie.");
        } else {
            System.out.println("Błąd podczas zastępowania pliku.");
        }

        return liczbaSztuk;
    }

    public static void main(String[] args) {
        String nazwaPliku = "dane.txt";
        String nazwaTowaru = "Koszulka";
        int liczbaSztuk = przetwarzajPlik(nazwaPliku, nazwaTowaru);
        System.out.println("Liczba sztuk towaru " + nazwaTowaru + " po rabacie: " + liczbaSztuk);
    }
}
