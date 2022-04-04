import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVManager {

    public static String DELIMITER = ",";

    public static List<String> read(String path) {
        List<String> values = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(path));
            scanner.useDelimiter(CSVManager.DELIMITER);
            while (scanner.hasNext()) {
                values.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("[FAIL] Error when reading CSV");
            System.out.println(e.getMessage());
        }
        System.out.println("[SUCCESS] Data has been read from CSV!");
        return values;
    }

    public static void write(String path, List<String> data) {
        try (PrintWriter writer = new PrintWriter(path)) {
            StringBuilder sb = new StringBuilder();
            for (String item : data) {
                sb.append(item);
                sb.append("\n");
            }
            writer.write(sb.toString());
            System.out.println("[SUCCESS] Data has been written to CSV!");
        } catch (FileNotFoundException e) {
            System.out.println("[FAIL] Error when writing CSV");
            System.out.println(e.getMessage());
        }
    }
}
