package br.com.alexandrejuniorc.gestaovagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Job for Java developer", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Gympass, VR/VA", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "Senior", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
