package br.com.alexandrejuniorc.gestaovagas.modules.company.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexandrejuniorc.gestaovagas.modules.company.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {

    // select * from job where description like '%filter%'

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
}
