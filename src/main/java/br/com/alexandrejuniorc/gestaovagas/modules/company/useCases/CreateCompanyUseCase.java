package br.com.alexandrejuniorc.gestaovagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alexandrejuniorc.gestaovagas.exceptions.ExceptionUserFound;
import br.com.alexandrejuniorc.gestaovagas.modules.company.entities.CompanyEntity;
import br.com.alexandrejuniorc.gestaovagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new ExceptionUserFound();
                });

        var encryptedPassword = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(encryptedPassword);
        
        return this.companyRepository.save(companyEntity);
    }
}
