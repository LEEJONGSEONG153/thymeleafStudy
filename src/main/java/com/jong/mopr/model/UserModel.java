package com.jong.mopr.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserModel {
    private String id;
    private String pw;
    private String role;
    private String name;
    private String email;
}
