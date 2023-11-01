package com.api.guiloker.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lockers", uniqueConstraints = @UniqueConstraint(columnNames = {"number", "sector"}))
public class LockerModel {

    @Id
    private String id;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private String studentCode;

    private String studentFullName;

    private int number;

    private String sector;

    @PrePersist
    private void generateId() {
        this.id = String.format("%d%s-%s", number, sector, UUID.randomUUID().toString());
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public int getNumber() {
        return number;
    }

    public String getSector() {
        return sector;
    }
}
