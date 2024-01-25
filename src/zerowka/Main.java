package zerowka;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {

    public static void main(String[] args) {

    }

    public static String emerytura(String nazwaPliku) throws FileNotFoundException, IOException {
        String imie, nazwisko, emeryt = null;
        char plec;
        int pesel, lataDoEmerytury, maxLatDoEmerytury = -1;
        long pozycja;
        RandomAccessFile raf = new RandomAccessFile(nazwaPliku, "rw");
        while (raf.getFilePointer() < raf.length()) {
            imie = raf.readUTF();
            nazwisko = raf.readUTF();
            plec = raf.readChar();
            pesel = raf.readInt();
            pozycja = raf.getFilePointer();
            lataDoEmerytury  = raf.readInt();
            lataDoEmerytury = plec == 'm' ? lataDoEmerytury - 2 : lataDoEmerytury - 7;
            raf.seek(pozycja);
            raf.writeInt(lataDoEmerytury);
            if (lataDoEmerytury > maxLatDoEmerytury) emeryt = imie + " " + nazwisko;
        }
        return emeryt;
    }

}