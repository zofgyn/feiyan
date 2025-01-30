package com.example.feiyuan03.repository;

import com.example.feiyuan03.model.TmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TmUserRepository extends JpaRepository<TmUser, Long>, JpaSpecificationExecutor<TmUser> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
} 