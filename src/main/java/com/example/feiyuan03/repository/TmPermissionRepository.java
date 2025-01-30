package com.example.feiyuan03.repository;

import com.example.feiyuan03.model.TmPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmPermissionRepository extends JpaRepository<TmPermission, Long>, JpaSpecificationExecutor<TmPermission> {
    boolean existsByPermissionCode(String permissionCode);
} 