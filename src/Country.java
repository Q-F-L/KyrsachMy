import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// @JsonDeserialize(using = CountryDeserializer.class)
public class Country {
    // @JsonProperty("options.string.name")
    private String name; // Название стран
    // @JsonProperty("options.array.products")
    private Product[] products;

    // Country() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
    //     setName(scanner.nextLine());
    //     System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
    //     setProducts();
    //     scanner.close();
    // }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
            setName(name);
        } else {
            this.name = name;
        }
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Product[] getProducts() {
        return products;
    }
}
