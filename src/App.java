import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        JsonFile json = new JsonFile();
        List<Country> countries = json.readJson("DB.json");
        
        do {
            int inputNumb = scanner.nextInt();

            switch (inputNumb) {
                case 0: // выход
                    return;
                case 1: // Вывести все страны и действия с ними
                    // Выбор страну и действия которые можно с ней делать
                    outputAllCountryDo(countries, scanner);
                    break;
                case 2: // Вывести все странны
                    for (Country country : countries) {
                        System.out.println(country.getName());
                    }
                    break;
                case 3: // отсортировать страны по названию
                    break;
                case 4: // отсортировать страны по количеству продуктов
                    break;
                case 5: // поиск стран по названию
                    break;
                default: // 
                    break;
            }
        }
        while(true);
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

        System.out.println("Введите код действия: ");
        boolean infiniteLoop = true;
        int inputNumb = scanner.nextInt();
        List<Product> products = countries.get(countryNumb).getProducts();

        do {
            switch (inputNumb) {
                case 1: // вывести все продукты и действия с ними
                    outputAllProductDo(countries, scanner, countryNumb);
                    break;
                case 2: // вывести все продукты
                    outputAllProduct(countries, scanner, countryNumb);
                    break;
                case 3: // найти продукт по названию
                    findProductByName(countries, scanner, countryNumb);
                    break;
                case 4: // добавить продукт
                    products.add(new Product());
                    break;
                default:
                    infiniteLoop = false;
                    break;
            }
        } while (infiniteLoop);
    }

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

    static public void outputAllProduct(List<Country> countries, Scanner scanner, int countryNumb) {
        int i = 0;
        List<Product> products = countries.get(countryNumb).getProducts();

        for (Product product : products) {
            System.out.println(i+". "+product.getName());
            i++;
        }
    }

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

        System.out.println("Введите код действия: ");
        boolean infiniteLoop1 = true;
        int inputNumb = scanner.nextInt();
        do {
            switch (inputNumb) {
                case 1: // вывести список эксопрта товара
                    outputAllExportDo(products, scanner, productNumb);
                    break;
                case 2: // добавить экспорт товара
                    break;
                case 3: // найти экспорт товара
                    break;
                case 4: // изменить имя
                    String name = scanner.nextLine();
                    product.setName(name);
                    break;
                case 5: // изменить категорию
                    String category = scanner.nextLine();
                    product.setCategory(category);
                    break;
                case 6: // изменить страну производитель
                    String countryOfOrigin = scanner.nextLine();
                    product.setCountryOfOrigin(countryOfOrigin);
                    break;
                case 7: // изменить цену
                    int price = scanner.nextInt();
                    product.setPrice(price);
                    break;
                default:
                    infiniteLoop1 = false;
                    break;
            }
        } while (infiniteLoop1);
    }

    static public void outputAllExportDo(List<Product> products, Scanner scanner, int productNumb) {
        int i = 0;
        System.out.println("Выберите экспорт из списка для дальнейшей работы с ним:");
        for (Export export : products.get(productNumb).getExports()) {
            System.out.println(i+". "+export.getCountryImportingGoods());
            i++;
        }

        int exportNumb = scanner.nextInt();
        Export export = products.get(productNumb).getExports().get(exportNumb);

        System.out.println("Вся информация о эспорте товара из страны \""+export.getCountryImportingGoods()+"\": ");
        System.out.println(export.toString());

        System.out.println("Введите код действия: ");
        boolean infiniteLoop1 = true;
        int inputNumb = scanner.nextInt();
        do {
            switch (inputNumb) {
                case 1: // изменить дату
                    System.out.println("Введите дату формата dd MM yyyy (пример 21 06 2002): ");
                    String date = scanner.nextLine();
                    export.setDate(date);
                    break;
                case 2: // изменить страну, импортирующию товар
                    System.out.println("Введите страну, импортирующию товар: ");
                    String countryImportingGoods = scanner.nextLine();
                    export.setCountryImportingGoods(countryImportingGoods);
                    break;
                case 3: // изменить объём партии в штуках
                    System.out.println("Введите объём партии в штуках: ");
                    int batchVolumeInPieces = scanner.nextInt();
                    export.setBatchVolumeInPieces(batchVolumeInPieces);;
                    break;
                default:
                    infiniteLoop1 = false;
                    break;
            }
        } while (infiniteLoop1);
    }
}
