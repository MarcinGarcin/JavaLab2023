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

            dis.close();
            DataInputStream dis2 = new DataInputStream(new FileInputStream(nazwaPliku));

            String[] towar = new String[linesAmount];
            double[] cena = new double[linesAmount];
            int[] sztuki = new int[linesAmount];

            for (int i = 0; i < linesAmount; i++) {
                towar[i] = dis2.readUTF();
                cena[i] = dis2.readDouble();
                sztuki[i] = dis2.readInt();

                if (towar[i].equals(nazwaTowaru) && sztuki[i] >= 100) {
                    sztuki[i] = (int) (sztuki[i] * rabat);
                    liczbaSztuk = sztuki[i];
                }

                dos.writeUTF(towar[i]);
                dos.writeDouble(cena[i]);
                dos.writeInt(sztuki[i]);
            }

            dis2.close();
            dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


        File staryPlik = new File(nazwaPliku);
        File nowyPlik = new File("temp.txt");
        if (staryPlik.delete() && nowyPlik.renameTo(staryPlik)) {
            System.out.println("Przetwarzanie zakończone pomyślnie.");
        } else {
            System.out.println("Błąd podczas zastępowania pliku.");
        }

        return liczbaSztuk;
    }

    public static void main(String[] args) throws IOException {
        String nazwaPliku = "dane.txt";
        String nazwaTowaru = "koszulka";
        int liczbaSztuk = przetwarzajPlik(nazwaPliku, nazwaTowaru);
        System.out.println("Liczba sztuk towaru " + nazwaTowaru + " po rabacie: " + liczbaSztuk);

    }
}
