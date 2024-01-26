package IITermin2016;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class A2 {
    public static int PrzeliczZamowienie(String fileName,String nazwaTowaru) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(fileName , "rw");
        String towar;
        int cena;
        int liczbaSztuk;
        int zwracanaLiczbaSztuk = 0;
        while (raf.getFilePointer() < raf.length()){
            System.out.println(raf.getFilePointer());
            towar = raf.readUTF();
            long pozPrzed =  raf.getFilePointer();
            cena = raf.readInt();
            liczbaSztuk = raf.readInt();
            if(liczbaSztuk>=250){
                raf.seek(pozPrzed);
                raf.write((int) (cena*0.9));
            }
            if(towar.equals(nazwaTowaru)){
                zwracanaLiczbaSztuk = liczbaSztuk;
            };
        }
        return zwracanaLiczbaSztuk;
    }

    public static void main(String[] args) throws IOException {
        PrzeliczZamowienie("plik.txt", "koszulka");

    }
}
