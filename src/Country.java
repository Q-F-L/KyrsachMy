import java.util.Scanner;

public class Country {
    private String name; // Название стран
    private Product products;

    Country(String name) {
        this.name = name;
    }

    Country() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
        setName(scanner.nextLine());
        System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
        setProducts();
        scanner.close();
    }

    public void setName(String name) {
        if (name.isEmpty()) {
            System.out.println("Вы ввели некоректное занчение\nВведите название страны: ");
            setName(name);
        } else {
            this.name = name;
        }
    }

    public void setProducts() {
        this.products = new Product();
    }

    public String getName() {
        return name;
    }

    public Product getProducts() {
        return products;
    }
}
