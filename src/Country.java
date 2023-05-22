import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// @JsonDeserialize(using = CountryDeserializer.class)
public class Country {
    private String name; // Название стран
    private List<Product> products; // Массив продуктов

    Country(@JsonProperty("name") String name, @JsonProperty("products") List<Product> products)
    {
        this.name = name;
        this.products = products;
    }

    Country()
    {
    }

    public String toString() {
        return "Имя: "+getName()+"\nПродукты: "+toStringProduct();
    }

    public String toStringProduct() {
        String str = "";
        for (Product product : products) {
            str += product.toString();
        }
        return str;
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
            setName(name);
        } else {
            this.name = name;
        }
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
