import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product extends Country{
    private String name; // Название товара
    private String category; // Название категории
    private String countryOfOrigin; // Страна-производитель
    private double price; // Цена
    private List<Export> exports; // Из каких стран Экспортируются

    Product(@JsonProperty("name") String name, @JsonProperty("category") String category,
    @JsonProperty("price") double price, @JsonProperty("countryOfOrigin") String countryOfOrigin,
    @JsonProperty("exports") List<Export> exports)
    {
        super();
        this.name = name;
        this.category = category;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.exports = exports;
    }

    Product(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("name:");
        this.name = scanner.nextLine();
        System.out.println("category:");
        this.category = scanner.nextLine();
        System.out.println("countryOfOrigin:");
        this.countryOfOrigin = scanner.nextLine();
        System.out.println("price:");
        this.price = scanner.nextDouble();
    }

    public String toString() {
        return "\n\tИмя: "+name+"\n\tКатегория: "+category+"\n\t Страна производитель: "+countryOfOrigin+"\n\tЦена: "+price+"\n\tИз каких стран экспортируются: "+toStringExports();
    }

    public String toStringExports() {
        String str = "";
        for (Export export : exports) {
            str += export.toString();
        }
        return str;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Вы ввели некоректное занчение\nВведите название товара: ");
            setName(name);
        } else {
            this.name = name;
        }
    }

    public void setCategory(String category) {
        if (category.isEmpty()) {
            System.out.println("Вы ввели некоректное занчение\nВведите название категории: ");
            setCategory(category);
        } else {
            this.category = category;
        }
    }

    public void setCountryOfOrigin(String countryOforigin) {
        this.countryOfOrigin = countryOforigin;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Вы ввели некоректное занчение\nВведите цену: ");
            setPrice(price);
        } else {
            this.price = price;
        }
    }

    public void setExports(List<Export> export) {
        this.exports = export;
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public double getPrice() {
        return price;
    }

    public List<Export> getExports() {
        return exports;
    }
}
