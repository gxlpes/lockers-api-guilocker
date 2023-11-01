package com.api.guiloker.dto.request;

import com.api.guiloker.dto.LockerDto;

import java.util.List;

public class LockerRequestDto {

    private String studentCode;

    private String studentFullName;

    private List<LockerDto> lockers;

    public String getStudentCode() {
        return studentCode;
    }

    public List<LockerDto> getLockers() {
        return lockers;
    }

    public String getStudentFullName() {
        return studentFullName;
    }
}
