package br.com.alexandrejuniorc.gestaovagas.modules.candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "John Doe", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate name")
    private String name;

    @NotBlank()
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaços!")
    @Schema(example = "johndoe", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate username")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido!")
    @Schema(example = "johndoe@mail.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate email")
    private String email;

    @Length(min = 10, max = 100, message = "O campo [password] deve conter entre 10 e 100 caracteres!")
    @Schema(example = "1234567899", minLength = 10, maxLength = 100, requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate password")
    private String password;

    @Schema(example = "Java developer", requiredMode = Schema.RequiredMode.REQUIRED, description = "Candidate description")
    private String description;

    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
