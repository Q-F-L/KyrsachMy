import java.util.Scanner;

public class Export extends Product{
    private String date; // Дата
    private String product; // Продукт
    private String countryImportingGoods; // Cтрана, импортирующей товар
    private int batchVolumeInPieces; // Объем партии в штуках

    // Export() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Введите дату (dd MM yyyy) Пример: 21 06 2023: ");
    //     setDate(scanner.nextLine());
    //     System.out.println("Введите название продукта: ");
    //     setProduct(new Product());
    //     System.out.println("Введите страны, импортирующей товар: ");
    //     setCountryImportingGoods(new Country());
    //     System.out.println("Введите объем партии в штуках: ");
    //     setBatchVolumeInPieces(scanner.nextInt());
    //     scanner.close();
    // }

    public void setDate(String date) {
        if (date.isEmpty()) {
            System.out.println("Вы ввели некоректное занчение\nВведите дату (dd MM yyyy) Пример: 21 06 2023: ");
            setDate(date);
        } else {
            this.date = date;
        }
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setCountryImportingGoods(String countryImportingGoods) {
        this.countryImportingGoods = countryImportingGoods;
    }

    public void setBatchVolumeInPieces(int batchVolumeInPieces) {
        if (batchVolumeInPieces < 0) {
            System.out.println("Вы ввели некоректное занчение\nОбъем партии в штуках: ");
            setBatchVolumeInPieces(batchVolumeInPieces);
        } else {
            this.batchVolumeInPieces = batchVolumeInPieces;
        }
    }



    public String getDate() {
        return date;
    }

    public String getProduct() {
        return product;
    }

    public String getCountryImportingGoods() {
        return countryImportingGoods;
    }

    public int getBatchVolumeInPieces() {
        return batchVolumeInPieces;
    }
}
