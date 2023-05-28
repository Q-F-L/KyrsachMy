import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        JsonFile json = new JsonFile();
        List<Country> countries = json.readJson("DB.json");
        do {
            System.out.println("1.Выход\n2.Выбор страну и действия которые можно с ней делать\n3.Вывести все странны"+
            "\n4.отсортировать страны по количеству продуктов\n5.поиск стран по названию\n6.Найти страны, в которые импортируется данный товар "+
            "\n7.Вывести минимальный и максимальный объем поставляемых партий данной страны\n8.Вывести наименование товаров, начинающихся с заданной буквы");
            System.out.println("Введите код действия: ");
            Scanner scanner = new Scanner(System.in);
            int inputNumb = scanner.nextInt()-1;
            switch (inputNumb) {
                case 0: // выход
                    json.writeJson(countries, "DB.json");
                    scanner.close();
                    return;
                case 1:// Выбор страну и действия которые можно с ней делать
                    outputAllCountryDo(countries, scanner);
                    break;
                case 2: // Вывести все странны
                    for (Country country : countries) {
                        System.out.println(country.getName());
                    }
                    break;
                case 3: // отсортировать страны по количеству продуктов
                    sortCountriesByAmountProductsLess(countries);
                    break;
                case 4: // отсортировать страны по количеству продуктов
                    sortCountriesByAmountProductsMore(countries);
                    break;
                case 5: // поиск стран по названию
                    findCountryByName(countries);
                    break;
                case 6: // Найти страны, в которые импортируется данный товар
                    findCountryToWhichThisProductIsImported(countries);
                    break;
                case 7: // Вывести минимальный и максимальный объем поставляемых партий данной страны
                    outputTheMinimumAndMaximumVolumeOfShipmentsOfAGivenCountry(countries);
                    break;
                case 8: // Вывести наименование товаров, начинающихся с заданной буквы
                    nameOfTheGoodsStartingWithTheSpecifiedLetter(countries);
                    break;
                default:
                    System.out.println("Введите число которым начинаеться строка");
                    break;
            }
        }
        while(true);
    }



    // Вывести наименование товаров, начинающихся с заданной буквы
    static public void nameOfTheGoodsStartingWithTheSpecifiedLetter(List<Country> countries) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите букву: ");
        char inputLetter = sc.nextLine().charAt(0);
        sc.close();
        ArrayList<String> str = new ArrayList<String>();
        int i = 0;

        for (Country country : countries) {
            for (Product product : country.getProducts()) {
                str.add(i++, product.getName());
            }
        }

        //Удаление повторяющихся элементов из массива
        for (i = 0; i < str.size(); i++) {
            for (int j = 0; j < str.size(); j++) {
                if(i != j && str.get(i).equals(str.get(j)) || str.get(j).charAt(0) != inputLetter) {
                    str.remove(j);
                }
            }
        }

        //Вывод массива
        for (String string : str) {
            System.out.println(string);
        }
    }

    // Вывести минимальный и максимальный объем поставляемых партий данной страны
    static public void outputTheMinimumAndMaximumVolumeOfShipmentsOfAGivenCountry(List<Country> countries) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название страны: ");
        String countryInput = sc.nextLine();
        sc.close();
        int min = Integer.MAX_VALUE;
        int max = 0;

        //Ппоиск максимального и минимального значения импорта страны по всей БД
        for (Country country : countries) {
            for (Product product : country.getProducts()) {
                for (Export export : product.getExports()) {
                    if (export.getCountryImportingGoods().equals(countryInput)) {
                        System.out.println(export.getCountryImportingGoods());
                        if(export.getBatchVolumeInPieces() < min) {
                            min = export.getBatchVolumeInPieces();
                        }

                        if(export.getBatchVolumeInPieces() > max) {
                            max = export.getBatchVolumeInPieces();
                        }
                    }
                }
            }
        }

        System.out.println("min = "+min+"  max = "+max);
    }

    static public void findCountryToWhichThisProductIsImported(List<Country> countries) {
        //Введите название товара
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название товара: ");
        String productInput = sc.nextLine();
        sc.close();

        //Выводит страны в которую импортируеться этот товар
        for (Country country : countries) {
            for (Product product : country.getProducts()) {
                if (product.getName().equals(productInput)) {
                    System.out.println(country.getName());
                }
            }
        }
    }

    static public void sortCountriesByAmountProductsLess(List<Country> countries) {
        for (int i = 0; i < countries.size(); i++) {
            for (int j = 0; j < countries.size(); j++) {
                if (countries.get(i).getProducts().size() < countries.get(j).getProducts().size()) {
                    Country buf = countries.get(j);
                    countries.set(j, countries.get(i));
                    countries.set(i, buf);
                }
            }
        }

        for (Country country : countries) {
            System.out.println(country.getName());
        }
    }

    static public void sortCountriesByAmountProductsMore(List<Country> countries) {
        for (int i = 0; i < countries.size(); i++) {
            for (int j = 0; j < countries.size(); j++) {
                if (countries.get(i).getProducts().size() > countries.get(j).getProducts().size()) {
                    Country buf = countries.get(j);
                    countries.set(j, countries.get(i));
                    countries.set(i, buf);
                }
            }
        }

        for (Country country : countries) {
            System.out.println(country.getName());
        }
    }

    static public void findCountryByName(List<Country> countries) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название :");
        String name = scanner.nextLine();
        scanner.close();

        for (Country country : countries) {
            if (country.getName().equalsIgnoreCase(name)) {
                System.out.println(i+". "+country.getName());
            }
            i++;
        }
    }

    static public void outputAllCountryDo(List<Country> countries, Scanner scanner) {
        int i = 0;
        System.out.println("Выберите странну из списка для дальнейшей работы с ней:");
        for (Country country : countries) {
            System.out.println(i+". "+country.getName());
            i++;
        }

        int countryNumb = scanner.nextInt();

        System.out.println("Вся информация о странне "+countries.get(countryNumb)+":");
        System.out.println(countries.get(countryNumb).toString());

        boolean infiniteLoop = true;
        List<Product> products = countries.get(countryNumb).getProducts();

        do {
            System.out.println("0.Выход\n1.Вывести все продукты и действия с ними\n2.Вывести все продукты"+
            "\n3.Найти продукт по названию\n4.Добавить продукт\n5.Вывести общий объем товаров, поставляемых в указанную страну");
            System.out.println("Введите код действия: ");
            int inputNumb = scanner.nextInt();

            switch (inputNumb) {
                case 0: return;//Выход
                case 1: // Вывести все продукты и действия с ними
                    outputAllProductDo(countries, scanner, countryNumb);
                    break;
                case 2: // Вывести все продукты
                    outputAllProduct(countries, scanner, countryNumb);
                    break;
                case 3: // Найти продукт по названию
                    findProductByName(countries, scanner, countryNumb);
                    break;
                case 4: // Добавить продукт
                    products.add(new Product(0));
                    break;
                case 5:// Вывести общий объем товаров, поставляемых в указанную страну
                    OutputTheTotalVolumeOfGoodsDeliveredToTheSpecifiedCountry(countries.get(countryNumb));
                    break;
                default:
                    System.out.println("Введите число которым начинаеться строка");
                    break;
            }
        } while (infiniteLoop);
    }

    // Вывести общий объем товаров, поставляемых в указанную страну
    static public void OutputTheTotalVolumeOfGoodsDeliveredToTheSpecifiedCountry(Country country){
        long amountProduct = 0;

        for (Product product : country.getProducts()) {
            for (Export export : product.getExports()) {
                amountProduct += export.getBatchVolumeInPieces();
            }
        }

        System.out.println(amountProduct);
    }

    // Найти продукт по названию
    static public void findProductByName(List<Country> countries, Scanner scanner, int countryNumb) {
        int i = 0;
        String name = scanner.nextLine();
        List<Product> products = countries.get(countryNumb).getProducts();

        for (Product product : products) {
            if (name == product.getName()) {
                System.out.println(i+". "+product.getName());
                i++;
            }
        }
    }

    // Вывести все продукты
    static public void outputAllProduct(List<Country> countries, Scanner scanner, int countryNumb) {
        int i = 0;
        List<Product> products = countries.get(countryNumb).getProducts();

        for (Product product : products) {
            System.out.println(i+". "+product.getName());
            i++;
        }
    }

    // Вывести все продукты и действия с ними
    static public void outputAllProductDo(List<Country> countries, Scanner scanner, int countryNumb) {
        int i = 0;
        List<Product> products = countries.get(countryNumb).getProducts();

        System.out.println("Выберите продукт из списка для дальнейшей работы с ним:");

        for (Product product : products) {
            System.out.println(i+". "+product.getName());
            i++;
        }

        int productNumb = scanner.nextInt();
        Product product = products.get(productNumb);
        System.out.println("Вся информация о эспорте \""+product.getName()+"\": ");
        System.out.println(product.toString());

        do {
            System.out.println("0.Выход\n1.Вывести список эксопрта товара\n2.Добавить экспорт товара"+
            "\n3.Найти экспорт товара\n4.Изменить имя\n5.Изменить категорию\n6.Изменить страну производитель\n7.Изменить цену");
            System.out.println("Введите код действия: ");
            int inputNumb = scanner.nextInt();
            switch (inputNumb) {
                case 0: return; // Выход
                case 1: // Вывести список эксопрта товара
                    outputAllExportDo(products, scanner, productNumb);
                    break;
                case 2: // Добавить экспорт товара
                    product.getExports().add(new Export(product.getName()));
                    break;
                case 3: // Найти экспорт товара
                    findExportByName(products.get(productNumb).getExports());
                    break;
                case 4: // Изменить имя
                    String name = scanner.nextLine();
                    product.setName(name);
                    break;
                case 5: // Изменить категорию
                    String category = scanner.nextLine();
                    product.setCategory(category);
                    break;
                case 6: // Изменить страну производитель
                    String countryOfOrigin = scanner.nextLine();
                    product.setCountryOfOrigin(countryOfOrigin);
                    break;
                case 7: // Изменить цену
                    int price = scanner.nextInt();
                    product.setPrice(price);
                    break;
                default:
                    System.out.println("Введите число которым начинаеться строка");
                    break;
            }
        } while (true);
    }

    // Найти продукт по названию
    static public void findExportByName(List<Export> exports) {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название страны импортера: ");
        String name = scanner.nextLine();

        for (Export export : exports) {
            if (name == export.getCountryImportingGoods()) {
                System.out.println(i+". "+export.getCountryImportingGoods());
                i++;
            }
        }
    }

    // Вывести список эксопрта товара
    static public void outputAllExportDo(List<Product> products, Scanner scanner, int productNumb) {
        int i = 0;
        System.out.println("Выберите экспорт из списка для дальнейшей работы с ним:");
        for (Export export : products.get(productNumb).getExports()) {
            System.out.println(i+". "+export.getCountryImportingGoods());
            i++;
        }

        int exportNumb = scanner.nextInt();
        Export export = products.get(productNumb).getExports().get(exportNumb);

        System.out.println(export.toString());

        do {
            System.out.println("Вся информация о эспорте товара из страны \""+export.getCountryImportingGoods()+"\": ");
            System.out.println("0.Выход\n1.Изменить дату\n2.Изменить страну, импортирующию товар\n"+
            "3.Изменить объём партии в штуках\n4.Удалить элемент");
            System.out.println("Введите код действия: ");
            int inputNumb = scanner.nextInt();

            switch (inputNumb) {
                case 1: // Изменить дату
                    System.out.println("Введите дату формата dd MM yyyy (пример 21 06 2002): ");
                    String date = scanner.nextLine();
                    export.setDate(date);
                    break;
                case 2: // Изменить страну, импортирующию товар
                    System.out.println("Введите страну, импортирующию товар: ");
                    String countryImportingGoods = scanner.nextLine();
                    export.setCountryImportingGoods(countryImportingGoods);
                    break;
                case 3: // Изменить объём партии в штуках
                    System.out.println("Введите объём партии в штуках: ");
                    int batchVolumeInPieces = scanner.nextInt();
                    export.setBatchVolumeInPieces(batchVolumeInPieces);;
                    break;
                case 4: // Удалить элемент
                    products.get(productNumb).getExports().remove(exportNumb);
                    break;
                default:
                    System.out.println("Введите число которым начинаеться строка БЕЗ точки");
                    break;
            }
        } while (true);
    }
}
