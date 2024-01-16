package IITermin2012;

import java.io.*;

public class Zad_B1  {


    public static void Emerytura(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter kobiety = new BufferedWriter(new FileWriter("kobiety.bin"));
        BufferedWriter mezczyzni  = new BufferedWriter(new FileWriter("mezczyzni.bin"));
        String line = "";
        String[] osoba = new String[4];
        while ((line = reader.readLine()) != null){
            osoba = line.split("-");
            if(osoba[2].equals("M")){
                int wiekDoEmerytury = (67- Integer.parseInt(osoba[3]))*12;
                mezczyzni.write(osoba[1]);
                mezczyzni.newLine();
                mezczyzni.write(Integer.toString(wiekDoEmerytury));
                mezczyzni.newLine();
            }
            else if(osoba[2].equals("K")){
                int wiekDoEmerytury = (65 - Integer.parseInt(osoba[3]))*12;
                kobiety.write(osoba[1]);
                kobiety.newLine();
                kobiety.write(Integer.toString(wiekDoEmerytury));
                kobiety.newLine();
            }


        }
        reader.close();
        kobiety.close();
        mezczyzni.close();

    }
    
    public static void main(String[] args) throws IOException {
        File dane = new File("dane.txt");
        Emerytura(dane);
    }

}
