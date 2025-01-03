package com.healthconnection.application.input.dto;

import com.healthconnection.shared.helper.TextHelper;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PatientDTO {
    
    private UUID id;  
    
    private String identification;

    private String firstName;
    
    private String middleName;
    
    private String lastName;
    
    private String middleLastName;
    
    private String email;

    private boolean confirmedEmail;

    private String phoneNumber;

    private boolean confirmedPhoneNumber;

    private String password;
    
    private String dateBirth;
    
    private IdentificationTypeDTO identificationType;
    
    private AffiliationRegimeDTO affiliationRegime;

    private EpsDTO eps;
    
    private boolean accountStatement;
    
    private String role;
    
    public PatientDTO() {
        setId(UuidHelper.DEFAULT_UUID);
        setIdentification(TextHelper.EMPTY);
        setFirstName(TextHelper.EMPTY);
        setMiddleName(TextHelper.EMPTY);
        setLastName(TextHelper.EMPTY);
        setMiddleLastName(TextHelper.EMPTY);
        setEmail(TextHelper.EMPTY);
        setConfirmedEmail(false);
        setPhoneNumber(TextHelper.EMPTY);
        setConfirmedPhoneNumber(false);
        setPassword(TextHelper.EMPTY);
        setDateBirth(TextHelper.EMPTY);
        setIdentificationType(new IdentificationTypeDTO());
        setAffiliationRegime(new AffiliationRegimeDTO());
        setEps(new EpsDTO());
        setAccountStatement(false);
        setRole(TextHelper.EMPTY);
    }
}

