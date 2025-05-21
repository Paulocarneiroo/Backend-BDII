package com.bdII.bdII.repositories;

import com.bdII.bdII.entities.Medicine;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends MongoRepository<Medicine, Long> {
}
