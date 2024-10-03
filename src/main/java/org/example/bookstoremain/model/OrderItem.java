package org.example.bookstoremain.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookTitle;
    private Double price;
    private Integer quantity; // Добавим количество для контроля

    // Здесь можно добавить связь с Book, если необходимо
}