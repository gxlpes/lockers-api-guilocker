package com.api.guiloker.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class LockerDto {
    @Min(value = 1, message = "Number should not be less than 1")
    @Max(value = 250, message = "Number should not be greater than 250")
    private int number;

    @NotBlank
    @Pattern(regexp = "GV[1-2]", message = "Sector should be GV1 or GV2")
    private String sector;

    public int getNumber() {
        return number;
    }

    public String getSector() {
        return sector;
    }
}
