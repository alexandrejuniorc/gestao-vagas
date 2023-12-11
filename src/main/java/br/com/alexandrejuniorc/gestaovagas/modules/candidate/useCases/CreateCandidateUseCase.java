package br.com.alexandrejuniorc.gestaovagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexandrejuniorc.gestaovagas.exceptions.ExceptionUserFound;
import br.com.alexandrejuniorc.gestaovagas.modules.candidate.CandidateEntity;
import br.com.alexandrejuniorc.gestaovagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new ExceptionUserFound();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
