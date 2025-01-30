package com.example.feiyuan03.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class TmRolePermissionId implements Serializable {
    private Long roleId;
    private Long permissionId;
} 