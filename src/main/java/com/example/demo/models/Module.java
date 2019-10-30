package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "modules")
@Data
public class Module implements Serializable {
    private static final long serializeVersionUID = 1L ;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;

    @Column(name = "module_code")
    private String moduleCode ;

    @Column(name = "module_name")
    private String moduleName ;
}
