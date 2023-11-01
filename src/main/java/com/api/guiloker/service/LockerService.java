package com.api.guiloker.service;

import com.api.guiloker.dto.request.LockerRequestDto;
import com.api.guiloker.exception.types.LockerAlreadyRentedException;
import com.api.guiloker.mapper.LockerMapper;
import com.api.guiloker.model.LockerModel;
import com.api.guiloker.repository.LockerRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LockerService {

    private final LockerRepository lockerRepository;
    private final LockerMapper lockerMapper;

    public LockerService(LockerRepository lockerRepository, LockerMapper lockerMapper) {
        this.lockerRepository = lockerRepository;
        this.lockerMapper = lockerMapper;
    }

    @Transactional
    public ResponseEntity<Object> rentLockers(LockerRequestDto lockerDtoRequest) {
        List<LockerModel> lockerModels = lockerMapper.mapToLockerModels(lockerDtoRequest);
            for (LockerModel lockerModel : lockerModels) {
                if (lockerRepository.existsByNumberAndSector(lockerModel.getNumber(), lockerModel.getSector())) {
                    throw new LockerAlreadyRentedException("Locker already rented");
                } else {
                    lockerRepository.save(lockerModel);
                }
            }

            return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

}

