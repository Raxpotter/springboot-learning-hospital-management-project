package com.RaxPotter.hospitalManagementSystem.entity;

import com.RaxPotter.hospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.metamodel.IdentifiableType;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    private LocalDate dateOfBirth;

    @Column(unique = true, nullable = false, length = 60)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Insurance insurance;

    @ToString.Exclude
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments = new ArrayList<>();

}
