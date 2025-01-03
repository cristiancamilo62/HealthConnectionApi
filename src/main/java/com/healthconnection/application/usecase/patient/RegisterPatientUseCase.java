package com.healthconnection.application.usecase.patient;

import com.healthconnection.application.usecase.UseCaseWithoutReturn;
import com.healthconnection.domain.PatientDomain;
import org.springframework.stereotype.Service;

@Service
public interface RegisterPatientUseCase extends UseCaseWithoutReturn<PatientDomain>{

}
