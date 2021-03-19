import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;

/**
 * @author Andrew Friedman.
 * @version 1.00.
 */
public class SatelliteDataConverter {
    private static Satellite[] createSatelliteArray(File input) {
        Satellite[] temp = new Satellite[input.listFiles().length];
        for (int i = 0; i < temp.length; i++) {
            try {
                File myObj = input.listFiles()[i];
                Scanner myReader = new Scanner(myObj);
                String data = "";
                while (myReader.hasNextLine()) {
                    data += "\n" + myReader.nextLine();
                }
                myReader.close();
                temp[i] = SatelliteTLEParser.parseData(data.substring(1));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("");
            }
        }
        return temp;
    }

    /**
     * [main description].
     * @param args [description].
     */
    public static void main(String[] args) {
        //File folder = new File(new Scanner(System.in).nextLine());
        String contentTemp = "";
        try {
            try {
                File folder = new File(args[0]);
                Satellite[] folderContents = createSatelliteArray(folder);
                for (int i = 0; i < folderContents.length; i++) {
                    contentTemp += "\n" + folderContents[i].encodeCSV();
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("");
            }
            FileWriter myObj = new FileWriter("satellite_output.csv");
            myObj.write((contentTemp.length() > 1) ? contentTemp.substring(1) : "");
            myObj.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("");
        }
    }
}
