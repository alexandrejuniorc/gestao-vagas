package br.com.alexandrejuniorc.gestaovagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobDTO {
    private String description;
    private String benefits;
    private String level;
}
