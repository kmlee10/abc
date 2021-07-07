package com.company.abc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class MemberInsertDTO {

    private String name;

    private String job;

    private int career;

    private Long teamId;

    private String phoneNumber;
}
