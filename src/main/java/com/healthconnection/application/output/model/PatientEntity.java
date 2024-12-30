package com.healthconnection.application.output.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Entity
@Table(name = "Patient")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter

public class PatientEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "patient_id")
	private UUID id;

	@Column(name = "identification")
	private String identification;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "middleName")
	private String middleName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "middleLastName")
	private String middleLastName;

	@Column(name = "email")
	private String email;

	@Column(name = "confirmedEmail")
	private boolean confirmedEmail;

	@Column(name = "phoneNumber")
	private String phoneNumber;

	@Column(name = "confirmedPhoneNumber")
	private boolean confirmedPhoneNumber;

	@Column(name = "password")
	private String password;

	@Column(name = "dateBirth")
	private String dateBirth;

	@ManyToOne
	@JoinColumn(name = "identificationType")
	private IdentificationTypeEntity identificationType;

	@ManyToOne
	@JoinColumn(name = "affiliationRegime")
	private AffiliationRegimeEntity affiliationRegime;

	@ManyToOne
	@JoinColumn(name = "eps")
	private EpsEntity eps;

	@Column(name = "accountStatement")
	private boolean accountStatement;

    @Column(name = "role")
    private String role;
}
