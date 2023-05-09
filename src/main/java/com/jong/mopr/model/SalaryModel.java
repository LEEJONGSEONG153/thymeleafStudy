package com.jong.mopr.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Builder
@Data
public class SalaryModel {
    private int id;
    @NonNull @Builder.Default private String name="이름없뜸";
    private String email;
}
