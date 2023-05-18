import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) throws Exception {
        JsonFile jsonFile = new JsonFile();
        List<Country> f = jsonFile.readJson("RussiaExportInCountry.json");
        for (Country val : f) {
            System.out.println(val.getName());
            for (Product product : val.getProducts()) {
                System.out.println(product.getName());
                for (Export export : product.getExports()) {
                    System.out.println(export.getBatchVolumeInPieces());
                }
            }
        }
        // ObjectMapper mapper = new ObjectMapper ();
        // JsonNode rootNode = mapper.readTree("src/dataBase/RussiaExportInCountry.json");
       
    }
}
