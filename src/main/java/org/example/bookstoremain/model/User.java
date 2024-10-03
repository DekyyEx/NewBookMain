package org.example.bookstoremain.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username; // Убедитесь, что это поле есть
    private String email;    // Если вы используете email
    private String password; // Поле для хранения пароля
}
