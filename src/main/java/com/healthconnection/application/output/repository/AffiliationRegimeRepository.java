package com.healthconnection.application.output.repository;

import com.healthconnection.application.output.model.AffiliationRegimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AffiliationRegimeRepository extends JpaRepository<AffiliationRegimeEntity, UUID>{

}
