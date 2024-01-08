package PlikiTekstowe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zad2 {

    public static List<String[]> openHouseData(String fileName) {
        List<String[]> listOfHouses = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                String[] houseParts = line.split("-");
                listOfHouses.add(houseParts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfHouses;
    }

    public static List<String[]> filterHouseByCriteria(List<String[]> allHouses, String houseName, String housePrice, String floorsAmount, String Location) {
        List<String[]> approvedHouses = new ArrayList<>();
        for (String[] houseData : allHouses) {
            if (houseData[2].equals(floorsAmount)  || houseData[3].equals(Location)) {
                approvedHouses.add(houseData);
            }
        }
        return approvedHouses;
    }

    public static List<String[]> decreasePriceBy10(List<String[]> approvedHouses) {
        for (String[] houseData : approvedHouses) {
            houseData[1] = String.valueOf(Double.parseDouble(houseData[1]) * 0.9);
        }
        return approvedHouses;
    }

    public static List<String> convertToString(List<String[]> approvedHouses) {
        String houseDataLine;
        List<String> stringHouseData = new ArrayList<>();
        for (String[] houseData : approvedHouses) {
            houseDataLine = houseData[0] + "-" + houseData[1] + "-" + houseData[2] + "-" + houseData[3];
            stringHouseData.add(houseDataLine);
        }
        return stringHouseData;
    }

    public static void writeToFile(List<String> housesToWrite, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : housesToWrite) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        List<String[]> houseDataTmp = openHouseData("danedomów");
        List<String> houseData = new ArrayList<>();

        houseDataTmp = filterHouseByCriteria(houseDataTmp,"dom","10k","1","Wies");
        houseDataTmp = decreasePriceBy10(houseDataTmp);
        houseData = convertToString(houseDataTmp);
        writeToFile(houseData,"danedomowkoniec");
    }
}


