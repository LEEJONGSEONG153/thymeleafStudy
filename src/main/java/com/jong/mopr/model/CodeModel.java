package com.jong.mopr.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class CodeModel {
    private String group_code;
    private String code;
    private String code_name;
}
