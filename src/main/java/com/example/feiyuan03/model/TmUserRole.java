package com.example.feiyuan03.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tm_user_role")
@IdClass(TmUserRoleId.class)
public class TmUserRole {
    @Id
    private Long userId;

    @Id
    private Long roleId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
} 