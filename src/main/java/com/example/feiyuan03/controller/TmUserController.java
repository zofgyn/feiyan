package com.example.feiyuan03.controller;

import com.example.feiyuan03.model.TmUser;
import com.example.feiyuan03.service.TmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户管理控制器。
 */
@RestController
@RequestMapping("/api/users")
public class TmUserController {
    @Autowired
    private TmUserService userService;

    /**
     * 获取分页用户列表。
     *
     * @param username 用于过滤的用户名（可选）
     * @param pageNum 要检索的页码（默认为1）
     * @param pageSize 每页的用户数量（默认为10）
     * @return 包含用户总数和用户列表的ResponseEntity
     */
    @GetMapping
    public ResponseEntity<Map<String, Object>> getUsers(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        
        Page<TmUser> page = userService.getUsers(username, PageRequest.of(pageNum - 1, pageSize));
        
        Map<String, Object> response = new HashMap<>();
        response.put("total", page.getTotalElements());
        response.put("rows", page.getContent());
        
        return ResponseEntity.ok(response);
    }

    /**
     * 根据ID获取用户。
     *
     * @param id 要检索的用户ID
     * @return 包含用户的ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<TmUser> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    /**
     * 创建新用户。
     *
     * @param user 要创建的用户对象
     * @return 包含创建用户的ResponseEntity
     */
    @PostMapping
    public ResponseEntity<TmUser> createUser(@RequestBody TmUser user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    /**
     * 更新现有用户。
     *
     * @param id 要更新的用户ID
     * @param user 包含更新信息的用户对象
     * @return 包含更新用户的ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<TmUser> updateUser(@PathVariable Long id, @RequestBody TmUser user) {
        user.setUserId(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    /**
     * 根据ID删除用户。
     *
     * @param id 要删除的用户ID
     * @return 表示成功删除的ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    /**
     * 为用户分配角色。
     *
     * @param id 要分配角色的用户ID
     * @param roleIds 要分配的角色ID数组
     * @return 表示成功分配的ResponseEntity
     */
    @PostMapping("/{id}/roles")
    public ResponseEntity<Void> assignRoles(
            @PathVariable Long id,
            @RequestBody Long[] roleIds) {
        userService.assignRoles(id, roleIds);
        return ResponseEntity.ok().build();
    }
} 