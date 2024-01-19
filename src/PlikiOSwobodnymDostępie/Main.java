package PlikiOSwobodnymDostępie;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("dane_domow.txt", "rw")) {


            long liczbaRekordow = file.length() / (4 * 2 + 8 + 4);

            for (int i = 0; i < liczbaRekordow; i++) {
                file.seek(i * (4 * 2 + 8 + 4));
                int liczbaKondygnacji = file.readInt();
                double cena = file.readDouble();
                String lokalizacja = file.readUTF();

                if (liczbaKondygnacji == 1 && lokalizacja.equals("wies")) {
                    cena *= 0.9;
                    file.seek(file.getFilePointer() - 8);
                    file.writeDouble(cena);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

