package br.com.alexandrejuniorc.gestaovagas.modules.candidate.controllers;

import br.com.alexandrejuniorc.gestaovagas.modules.candidate.CandidateEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandrejuniorc.gestaovagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.alexandrejuniorc.gestaovagas.modules.candidate.useCases.AuthCandidateUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidate")
@Tag(name = "Authentication", description = "Authentication of routes")
public class AuthCandidateController {

    @Autowired
    private AuthCandidateUseCase authCandidateUseCase;

    @PostMapping("/auth")
    @Operation(summary = "Candidate Authentication", description = "This function is responsible to authenticate a candidate")
    @ApiResponses({
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CandidateEntity.class))
            })
    })
    public ResponseEntity<Object> auth(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO) {

        try {
            var result = this.authCandidateUseCase.execute(authCandidateRequestDTO);

            return ResponseEntity
                    .ok()
                    .body(result);
        } catch (Exception e) {

            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }

    }

}
