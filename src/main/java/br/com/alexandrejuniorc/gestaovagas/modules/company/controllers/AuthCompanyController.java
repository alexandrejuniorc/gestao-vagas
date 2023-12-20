package br.com.alexandrejuniorc.gestaovagas.modules.company.controllers;

import br.com.alexandrejuniorc.gestaovagas.modules.candidate.CandidateEntity;
import br.com.alexandrejuniorc.gestaovagas.modules.company.entities.CompanyEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandrejuniorc.gestaovagas.modules.company.dto.AuthCompanyDTO;

import br.com.alexandrejuniorc.gestaovagas.modules.company.useCases.AuthCompanyUseCase;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company")
@Tag(name = "Authentication", description = "Authentication of routes")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;

    @PostMapping("/auth")
    @Operation(summary = "Company Authentication", description = "This function is responsible to authenticate a company")
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CompanyEntity.class))
            })
    })
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        try {
            var result = this.authCompanyUseCase.execute(authCompanyDTO);
            
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }

    }

}
