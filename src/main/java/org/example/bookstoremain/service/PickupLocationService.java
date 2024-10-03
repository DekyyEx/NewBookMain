package org.example.bookstoremain.service;

import org.example.bookstoremain.model.PickupLocation;
import org.example.bookstoremain.repository.PickupLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickupLocationService {

    private final PickupLocationRepository pickupLocationRepository;

    @Autowired
    public PickupLocationService(PickupLocationRepository pickupLocationRepository) {
        this.pickupLocationRepository = pickupLocationRepository;
    }

    public List<PickupLocation> findAll() {
        return pickupLocationRepository.findAll();
    }

    public Optional<PickupLocation> findById(Long id) {
        return pickupLocationRepository.findById(id);
    }

    public List<PickupLocation> findByCity(String city) {
        return pickupLocationRepository.findByCity(city);
    }

    public PickupLocation save(PickupLocation location) {
        return pickupLocationRepository.save(location);
    }

    public PickupLocation update(Long id, PickupLocation location) {
        location.setId(id); // Убедитесь, что у объекта есть правильный id
        return pickupLocationRepository.save(location);
    }

    public void deleteById(Long id) {
        pickupLocationRepository.deleteById(id);
    }
}
