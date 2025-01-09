package com.healthconnection.infrastructure.adapters.persistence;

import com.healthconnection.domain.model.patient.PatientDomain;
import com.healthconnection.domain.ports.output.PatientRepositoryPort;
import com.healthconnection.infrastructure.adapters.persistence.mapper.PatientMapperEntity;
import com.healthconnection.infrastructure.entities.PatientEntity;
import com.healthconnection.infrastructure.repositories.PatientJpaRepository;
import com.healthconnection.shared.helper.UuidHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PatientPersistenceAdapter implements PatientRepositoryPort {

    private final PatientJpaRepository patientJpaRepository;

    private final PatientMapperEntity patientMapperEntity;

    @Override
    public void save(PatientDomain patient) {

        PatientEntity patientEntity = patientMapperEntity.toEntity(patient);

        patientJpaRepository.save(patientEntity);
    }

    @Override
    public Optional<PatientDomain> findById(UUID id) {
        return patientJpaRepository.findById(id).
                map(patientMapperEntity::toDomain);
    }

    @Override
    public List<PatientDomain> findAll() {
        return patientJpaRepository.findAll().stream()
                .map(patientMapperEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public List<PatientDomain> findAllExample(PatientDomain patient) {

        var patientEntity = patientMapperEntity.toEntity(patient);

        if (isUuidValid(patientEntity.getIdentificationType().getId())) {
            patientEntity.setIdentificationType(null);
        }
        if (isUuidValid(patientEntity.getAffiliationRegime().getId())) {
            patientEntity.setAffiliationRegime(null);
        }
        if (isUuidValid(patientEntity.getEps().getId())) {
            patientEntity.setEps(null);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<PatientEntity> example = Example.of(patientEntity, matcher);

        return patientMapperEntity.toListDomain(patientJpaRepository.findAll(example));

    }

    private boolean isUuidValid(UUID uuid) {
        return UuidHelper.isDefault(uuid) || UuidHelper.isUuidEmpty(uuid);
    }


    @Override
    public void deleteById(UUID id) {
        patientJpaRepository.findById(id).ifPresent(patient ->{
            patient.setAccountStatement(false);
            patientJpaRepository.save(patient);
        });
    }

    @Override
    public boolean existsById(UUID id) {
        return patientJpaRepository.existsById(id);
    }

    @Override
    public Optional<PatientDomain> findByIdentification(String identification) {

        Optional<PatientEntity> entities =  patientJpaRepository.findByIdentification(identification);

        return  patientMapperEntity.toOptionalDomain(entities);
    }

    @Override
    public boolean existsByEmail(String email) {
        return patientJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByEmailAndPassword(String user, String password) {
        return patientJpaRepository.existsByEmailAndPassword(user, password);
    }

    @Override
    public Optional<PatientDomain> findByEmail(String email) {
        Optional<PatientEntity> entities =  patientJpaRepository.findByEmail(email);

        return patientMapperEntity.toOptionalDomain(entities);
    }
}
