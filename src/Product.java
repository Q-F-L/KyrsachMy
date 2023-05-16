import java.util.Scanner;

public class Product extends Country{
    private String name; // Название товара
    private String category; // Название категории
    private Country countryOfOrigin; // Страна-производитель
    private double price; // Цена
    private Export exports; // Из каких стран Экспортируются

    Product() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара: ");
        setName(scanner.nextLine());
        System.out.println("Введите название категории: ");
        setCategory(scanner.nextLine());
        System.out.println("Введите страну-производитель:");
        setCountryOfOrigin(new Country());
        System.out.println("Введите цену: ");
        setPrice(scanner.nextDouble());
        scanner.close();
    }

    Product(String name,String category,Country countryOfOrigin, double price) {
        this.name = name;
        this.category = category;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
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

    public void setCountryOfOrigin(Country countryOforigin) {
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

    public void setExports() {
        this.exports = new Export();
    }


    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public double getPrice() {
        return price;
    }

    public Export getExports() {
        return exports;
    }
}
