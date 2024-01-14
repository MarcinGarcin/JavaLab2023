package IITermin2012;

import java.io.*;

public class Zad_A2 {


    private static void nadwaga(File file) throws IOException {
        String line = "";
        String[] osoba = new String[4];
        double BMI;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter nadwaga = new BufferedWriter(new FileWriter("nadwaga.bin"));
        BufferedWriter niedowaga = new BufferedWriter(new FileWriter("niedowaga.bin"));
        while ((line = reader.readLine()) != null){

            osoba = line.split("-");
            double weight = Double.parseDouble(osoba[2]);
            double height = Double.parseDouble(osoba[3]);
            double bmi = weight/Math.pow(2,height);
            if(bmi>=25.00){

                nadwaga.write(osoba[0]);
                nadwaga.newLine();
                nadwaga.write(Double.toString(bmi));
                nadwaga.newLine();
            } else if (bmi<18.5) {
                niedowaga.write(osoba[0]);
                niedowaga.newLine();
                niedowaga.write(Double.toString(bmi));
                niedowaga.newLine();
            }



        }
        reader.close();
        nadwaga.close();
        niedowaga.close();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("dane.txt");
        nadwaga(file);

    }
}
