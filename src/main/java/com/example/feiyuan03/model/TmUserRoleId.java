package com.example.feiyuan03.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class TmUserRoleId implements Serializable {
    private Long userId;
    private Long roleId;
} 