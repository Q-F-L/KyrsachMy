import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiConsumer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    public static void main(String[] args) throws Exception {
        JsonFile jsonFile = new JsonFile();
        Map<String, Country[]> f = jsonFile.readJson("RussiaExportInCountry.json");
        System.out.println(f);

        // ObjectMapper mapper = new ObjectMapper ();
        // JsonNode rootNode = mapper.readTree("src/dataBase/RussiaExportInCountry.json");
       
    }
}
