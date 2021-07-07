package com.company.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TeamInsertDTO {

    private String name;

    private Long companyId;

}
