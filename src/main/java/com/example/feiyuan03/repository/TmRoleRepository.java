package com.example.feiyuan03.repository;

import com.example.feiyuan03.model.TmRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmRoleRepository extends JpaRepository<TmRole, Long>, JpaSpecificationExecutor<TmRole> {
    boolean existsByRoleName(String roleName);
} 