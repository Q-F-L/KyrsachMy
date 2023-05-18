import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFile {
    final String path = "src/dataBase/"; // Путь к базе данных
    final ObjectMapper mapper = new ObjectMapper ();

    /*
     * Вывести все названия фалов в дикертории path
     */
    public ArrayList<String> getAll()
    {
        File myObj = new File(path);
        ArrayList<String> array = new ArrayList<String>();

        for (String string : myObj.list()) {
            array.add(string);
        }

        return array;
    }

    /*
     * Показать все названия фалов в дикертории path без расширения
     */
    public void viewAll()
    {
        File myObj = new File(path);
        
        for (String string : myObj.list()) {
            System.out.print(string.substring(0, string.length()-5)+"\n");
        }
    }

    /*
     * Создание файла
     */
    public void createFile(String fileName)
    {
        try {
            File myObj = new File(path+fileName+".json");
            if (myObj.createNewFile()) {
              System.out.println("ФАйл создан: " + myObj.getName());
            } else {
              System.out.println("Файл существует.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }
    }

    /*
     * Удаление файла
     */
    public void deleteFile(String fileName)
    {
        File myObj = new File(path+fileName+".json");
        if (myObj.delete()) {
            System.out.println("Файл удален: " + myObj.getName());
        } else {
            System.out.println("Файла не существует.");
        }
    }

    /*
    * Запись в файл
    */
    public void writeJson(ArrayList<Country> arrayForWrite, String fileOutput) throws IOException, StreamReadException, DatabindException
    {
        ObjectMapper mapper = new ObjectMapper ();	
        mapper.writeValue(new File(path+fileOutput), arrayForWrite);
    }

    /*
     * Чтение файла
     */
    public List<Country> readJson(String fileInput) throws JsonParseException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Country>> type = new TypeReference<List<Country>>() {};
        List<Country> dataMap = mapper.readValue(new File(path+fileInput), type);
        return dataMap;
    }
}

