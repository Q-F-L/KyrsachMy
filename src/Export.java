import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Export extends Product{
    private String date; // Дата
    private String product = super.getName(); // Продукт
    private String countryImportingGoods; // Cтрана, импортирующей товар
    private int batchVolumeInPieces; // Объем партии в штуках

    Export(@JsonProperty("date") String date, @JsonProperty("product") String product,
    @JsonProperty("countryImportingGoods") String countryImportingGoods, @JsonProperty("batchVolumeInPieces") int batchVolumeInPieces)
    {
        super();
        this.date = date;
        this.product = product;
        this.countryImportingGoods = countryImportingGoods;
        this.batchVolumeInPieces = batchVolumeInPieces;
    }

    Export(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату формата dd MM yyyy (пример 21 06 2002): ");
        setDate(scanner.nextLine());
        System.out.println("Введите страну, импортирующию товар: ");
        setCountryImportingGoods(scanner.nextLine());
        System.out.println("Введите объём партии в штуках: ");
        setBatchVolumeInPieces(scanner.nextInt());
        setProduct(product);
    }

    public String toString() {
        return "\n\t\tДата: "+date+";\n\t\tПродукт: "+product+";\n\t\tCтрана, импортирующей товар: "+countryImportingGoods+";\n\t\tОбъем партии в штуках: "+batchVolumeInPieces+";\n";
    }

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
