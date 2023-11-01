package com.api.guiloker.repository;

import com.api.guiloker.model.LockerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LockerRepository extends JpaRepository<LockerModel, Long> {
    boolean existsByNumberAndSector(int number, String sector);
}
