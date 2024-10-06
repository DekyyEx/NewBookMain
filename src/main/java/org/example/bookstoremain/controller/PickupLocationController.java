package org.example.bookstoremain.controller;

import org.example.bookstoremain.entity.PickupLocation;
import org.example.bookstoremain.service.PickupLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pickup-locations")
public class PickupLocationController {

    private final PickupLocationService pickupLocationService;

    @Autowired
    public PickupLocationController(PickupLocationService pickupLocationService) {
        this.pickupLocationService = pickupLocationService;
    }

    @GetMapping
    public List<PickupLocation> getAllLocations() {
        return pickupLocationService.findAll();
    }

    @GetMapping("/{id}")
    public PickupLocation getLocationById(@PathVariable Long id) {
        return pickupLocationService.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @GetMapping("/city/{city}")
    public List<PickupLocation> getLocationsByCity(@PathVariable String city) {
        return pickupLocationService.findByCity(city);
    }

    @PostMapping
    public PickupLocation createLocation(@RequestBody PickupLocation location) {
        return pickupLocationService.save(location);
    }

    @PutMapping("/{id}")
    public PickupLocation updateLocation(@PathVariable Long id, @RequestBody PickupLocation location) {
        return pickupLocationService.update(id, location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        pickupLocationService.deleteById(id);
    }
}
