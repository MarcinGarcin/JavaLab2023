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

            liczbaSztuk = 0;
            boolean znaleziono = false;

            while (true) {
                try {
                    String towar = dis.readUTF();
                    double cena = dis.readDouble();
                    int sztuki = dis.readInt();

                    if (towar.equals(nazwaTowaru) && sztuki >= 100) {
                        sztuki = (int) (sztuki * rabat);
                        znaleziono = true;
                    }

                    dos.writeUTF(towar);
                    dos.writeDouble(cena);
                    dos.writeInt(sztuki);

                    if (towar.equals(nazwaTowaru)) {
                        liczbaSztuk = sztuki;
                    }
                } catch (EOFException e) {
                    break;  // Koniec pliku
                }
            }

            if (!znaleziono) {
                System.out.println("Nie znaleziono towaru o nazwie " + nazwaTowaru);
                return 0;
            }

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
    public static void main(String[] args) {
        String nazwaPliku = "dane.txt";
        String nazwaTowaru = "Koszulka";
        int liczbaSztuk = przetwarzajPlik(nazwaPliku, nazwaTowaru);
        System.out.println("Liczba sztuk towaru " + nazwaTowaru + " po rabacie: " + liczbaSztuk);
    }
}

