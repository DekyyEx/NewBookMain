package org.example.bookstoremain.repository;

import org.example.bookstoremain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEmail(String email); // Метод для поиска пользователей по email
}
