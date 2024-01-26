package IITermin2014;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class A3 {

    private static void przetwarzanie(String filePath)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> linie = new ArrayList<>();
        String line;
        while((line = reader.readLine()) != null){
            line = line.substring(0,line.length()-3);
            int licznikZnakow = 0;
            int licznikOperatorow = 0;
            for(int i = 0; i < line.length();i++){
                char znak = line.charAt(i);
                if (znak == 'a'|| znak == 'b'){
                    licznikZnakow++;
                }
                else{
                    licznikOperatorow++;
                }
            }
            if((licznikZnakow-licznikOperatorow)==1){
                linie.add(line + " 1");
            }
            else{
                linie.add(line + " 0");
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for(String linia: linie){
            System.out.println(linia);
            writer.write(linia);
            writer.newLine();
        }
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        przetwarzanie("plik.txt");
    }
}
