package com.healthconnection.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "AffiliationRegime")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public final class AffiliationRegimeEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "type")
    private String type;

    @Column(name = "serviceCoverages")
    private String serviceCoverages;

}