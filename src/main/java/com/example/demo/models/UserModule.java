package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_module")
@Data
public class UserModule implements Serializable {
    private static final long serializeVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "module_id")
    private Long moduleId;

    @Column(name = "order_section")
    private Long menuOrder;

}
