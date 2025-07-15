package com.anhangda37.basis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private Long id;

    @Column(name = "contact_name", columnDefinition = "VARCHAR(30)", nullable = false)
    private String name;

    @Column(name = "contact_phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "created_time")
    private LocalDateTime createdAt;

    @PostPersist
    void preUpdate() {
        createdAt = LocalDateTime.now();
    }
}
