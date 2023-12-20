package br.com.alexandrejuniorc.gestaovagas.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    private UUID id;

    @Schema(example = "John Doe")
    private String name;

    @Schema(example = "johndoe")
    private String username;

    @Schema(example = "johndoe@mail.com")
    private String email;

    @Schema(example = "Java developer")
    private String description;
}
