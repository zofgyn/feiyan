package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "tm_permissions")
public class TmPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long permissionId;

    @Column(nullable = false, unique = true, length = 100)
    private String permissionName;

    @Column(nullable = false, unique = true, length = 100)
    private String permissionCode;

    @Column
    private String permissionDesc;

    @Column(nullable = false)
    private Integer type = 1;

    @Column
    private Long parentId = 0L;

    @Column(nullable = false)
    private Integer status = 1;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "permissions")
    private Set<TmRole> roles;
} 