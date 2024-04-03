package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private Long productId;
    private String name;
    private LocalDate dateSupplied;
    private Integer quantityInStock;
    private BigDecimal unitPrice;

    public Product() {
    }

    public Product(Long productId, String name, LocalDate dateSupplied, Integer quantityInStock,
            BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(Long productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateSuppliedFormatted() {
        return DateTimeFormatter.ISO_LOCAL_DATE.format(this.dateSupplied);
    }

    public LocalDate getDateSupplied() {
        return this.dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String json() {
        return String.format(
                "\t{\"productId\": %s, \"name\": \"%s\", \"dateSupplied\": \"%s\", \"quantityInStock\": %s, \"unitPrice\": %s}",
                getProductId(), getName(), getDateSuppliedFormatted(), getQuantityInStock(), getUnitPrice());
    }

    public String xml() {
        return String.format(
                "\t<product productId=\"%s\" name=\"%s\" dateSupplied=\"%s\" quantityInStock=\"%s\" unitPrice=\"%s\"/>%n",
                getProductId(), getName(), getDateSuppliedFormatted(), getQuantityInStock(), getUnitPrice());

    }

    public String csv() {
        return String.format(
                "%s, %s, %s, %s, %s%n",
                getProductId(), getName(), getDateSuppliedFormatted(), getQuantityInStock(), getUnitPrice());

    }

    public String print(FormatType type) {
        switch (type) {
            default:
            case JSON:
                return this.json();
            case XML:
                return this.xml();
            case CSV:
                return this.csv();
        }
    }
}
