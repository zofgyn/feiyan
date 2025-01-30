package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tm_role_permission")
@IdClass(TmRolePermissionId.class)
public class TmRolePermission {
    @Id
    private Long roleId;

    @Id
    private Long permissionId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
} 