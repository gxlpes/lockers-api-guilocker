package com.api.guiloker.controller;

import com.api.guiloker.dto.request.LockerRequestDto;
import com.api.guiloker.service.LockerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/lockers")
public class LockerController {
    private final LockerService lockerService;

    public LockerController(LockerService lockerService) {
        this.lockerService = lockerService;
    }

    @PostMapping()
    public ResponseEntity<Object> rentLockers(@Valid @RequestBody LockerRequestDto lockerDtoRequest) {
        return lockerService.rentLockers(lockerDtoRequest);
    }
}
