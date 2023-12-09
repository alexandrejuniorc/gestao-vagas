package br.com.alexandrejuniorc.gestaovagas.modules.candidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
}
