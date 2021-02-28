/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PNB_Transaction_Importer_Gradle;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Main main = new Main();
        main.readCsv("input_files/4356XXXXXXXXX854510-03-2020.csv");
    }

    void readCsv(String csvFile) {

//        String csvFile = "input_files/4356XXXXXXXXX854510-03-2020.csv";
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(getClass().getClassLoader().getResource(csvFile).getFile()));
            String[] line;
            int i = 1;
            while ((line = reader.readNext()) != null) {

                if (i >= 18 && i <= 26) {

//                    Arrays.stream(line).forEach(System.out::println);
                    System.out.println("Transaction Date= " + line[1] + ", Withdrawal=" + (line[5].isEmpty() ? "0" : line[5]) + ", Deposit=" + (line[7].isEmpty() ? "0" : line[7]) + ", Particulars=" + line[9]);
                }
                i++;
            }
        } catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
    }
}
