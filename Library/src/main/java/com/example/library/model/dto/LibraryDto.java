package com.example.library.model.dto;

public class LibraryDto {
    private int id;
    private String isbn;
    private int quantity;

    public LibraryDto() {
    }

    public LibraryDto(int id, String isbn, int quantity) {
        this.id = id;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public LibraryDto(String isbn, int quantity) {
        this.isbn = isbn;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
