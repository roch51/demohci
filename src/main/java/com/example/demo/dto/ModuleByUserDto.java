package com.example.demo.dto;

import lombok.Data;

@Data
public class ModuleByUserDto {

    private String moduleName;
    private Long menuOrder;

    public ModuleByUserDto(String moduleName, Long menuOrder) {
        this.moduleName = moduleName;
        this.menuOrder = menuOrder;
    }
}
