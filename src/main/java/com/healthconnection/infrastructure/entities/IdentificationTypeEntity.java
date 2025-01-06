package com.healthconnection.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "IdentificationType")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationTypeEntity {

    @Id
    @Column(name = "identification_type_id")
    private UUID id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

}