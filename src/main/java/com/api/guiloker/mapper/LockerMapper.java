package com.api.guiloker.mapper;

import com.api.guiloker.dto.LockerDto;
import com.api.guiloker.dto.request.LockerRequestDto;
import com.api.guiloker.model.LockerModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LockerMapper {

    public List<LockerModel> mapToLockerModels(LockerRequestDto lockerRequestDto) {
        List<LockerDto> lockerDtos = lockerRequestDto.getLockers();
        return lockerDtos.stream().map(lockerDto -> mapToLockerModel(lockerRequestDto.getStudentCode(), lockerRequestDto.getStudentFullName(), lockerDto)).collect(Collectors.toList());
    }

    public LockerModel mapToLockerModel(String studentCode, String studentFullName, LockerDto lockerDto) {
        LockerModel lockerModel = new LockerModel();
        lockerModel.setStudentCode(studentCode);
        lockerModel.setNumber(lockerDto.getNumber());
        lockerModel.setSector(lockerDto.getSector());
        lockerModel.setStudentFullName(studentFullName);

        return lockerModel;
    }
}
