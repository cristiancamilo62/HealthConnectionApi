package com.healthconnection.application.output.repository;

import com.healthconnection.application.output.model.EpsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EpsRepository extends JpaRepository<EpsEntity, UUID>{

}
