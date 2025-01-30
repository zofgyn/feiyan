package com.example.feiyuan03.service;

import com.example.feiyuan03.model.TmUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TmUserService {
    TmUser createUser(TmUser user);
    TmUser updateUser(TmUser user);
    void deleteUser(Long userId);
    TmUser getUserById(Long userId);
    Page<TmUser> getUsers(String username, Pageable pageable);
    void assignRoles(Long userId, Long[] roleIds);
}