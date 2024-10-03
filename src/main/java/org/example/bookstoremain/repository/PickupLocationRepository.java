package org.example.bookstoremain.repository;

import org.example.bookstoremain.model.PickupLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PickupLocationRepository extends JpaRepository<PickupLocation, Long> {
    List<PickupLocation> findByCity(String city); // Этот метод ищет пункты выдачи по городу
}
