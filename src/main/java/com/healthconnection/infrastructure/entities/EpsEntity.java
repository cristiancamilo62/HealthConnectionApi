package com.healthconnection.infrastructure.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Eps")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpsEntity {

    @Id
    @Column(name = "eps_id")
    private UUID id;

    @Column(name = "name")
    private String name;

}