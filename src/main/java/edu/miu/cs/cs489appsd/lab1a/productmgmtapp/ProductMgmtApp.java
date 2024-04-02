package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.FormatType;
import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

public class ProductMgmtApp {
    private static String serialize(Product[] products, FormatType type) {
        String title = "Printed in JSON Format";
        String header = "[";
        String footer = "]";
        String delimiter = "";

        if (type == FormatType.JSON) {
            delimiter = ",\n";
        }

        switch (type) {
            case JSON:
                title = "Printed in JSON Format";
                header = "[\n";
                footer = "\n]";
                break;
            case XML:
                title = "Printed in XML Format";
                header = "<?xml version=\"1.0\"?>\n<products>\n";
                footer = "</products>";
                break;
            case CSV:
                title = "Printed in Comma-Separated Value(CSV) Format";
                header = "";
                footer = "";
                break;

            default:
                break;
        }

        Stream<Product> productStream = Arrays.stream(products);

        String body = productStream.sorted((product1, product2) -> product1.getName().compareTo(product2.getName()))
                .map(product -> {
                    switch (type) {
                        default:
                        case JSON:
                            return product.json();
                        case XML:
                            return product.xml();
                        case CSV:
                            return product.csv();
                    }
                }).collect(Collectors.joining(delimiter));

        String hr = "------------------------------------------------------";
        return String.format("%s%n%s%s%s%n%s", title, header, body, footer, hr);
    }

    private static void printProducts(Product[] products, FormatType type) {
        System.out.println(serialize(products, type));
    }

    private static void printProducts(Product[] products) {
        printProducts(products, FormatType.JSON);
        printProducts(products, FormatType.XML);
        printProducts(products, FormatType.CSV);
    }

    public static void main(String[] args) {
        Product[] products = new Product[] {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124,
                        BigDecimal.valueOf(0.55)),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18,
                        BigDecimal.valueOf(1.09)),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89,
                        BigDecimal.valueOf(2.99))
        };

        printProducts(products);
    }
}