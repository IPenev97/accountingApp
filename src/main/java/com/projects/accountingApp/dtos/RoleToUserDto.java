package com.projects.accountingApp.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleToUserDto {
    private String username;
    private String roleName;

}
