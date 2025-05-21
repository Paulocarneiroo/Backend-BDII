package com.bdII.bdII.services;

import com.bdII.bdII.entities.Medicine;
import com.bdII.bdII.repositories.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository repository;

    public List<Medicine> findAll() {
        return repository.findAll();
    }

    public Optional<Medicine> findById(Long id) {
        return repository.findById(id);
    }

    public Medicine save(Medicine user) {
        return repository.save(user);
    }

    public Medicine update(Long id, Medicine medicine) {
        return repository.findById(id)
                .map(existingMedicine -> {
                    medicine.setName(medicine.getName());
                    medicine.setFrequency(medicine.getFrequency());
                    return repository.save(medicine);
                })
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado com ID: " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
